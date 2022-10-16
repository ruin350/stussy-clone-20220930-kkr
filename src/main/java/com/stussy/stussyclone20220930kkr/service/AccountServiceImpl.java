package com.stussy.stussyclone20220930kkr.service;

import com.stussy.stussyclone20220930kkr.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930kkr.domain.User;
import com.stussy.stussyclone20220930kkr.dto.RegisterReqDto;
import com.stussy.stussyclone20220930kkr.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220930kkr.exception.CustomValidationException;
import com.stussy.stussyclone20220930kkr.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    @LogAspect
    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception{
        // 이메일 중복확인
        User user = registerReqDto.toEntity();
        int result = accountRepository.saveUser(user);
        if(result == 0) {
            throw new CustomInternalServerErrorException("회원가입오류");
        }
    }
    @LogAspect
    @Override
    public void duplicateEmail(RegisterReqDto registerReqDto) throws Exception {
        // 회원가입 진행
        User user = accountRepository.findUserByEmail(registerReqDto.getEmail());

        if(user != null) {
            Map<String,String> errorMap = new HashMap<String,String>();
            errorMap.put("email", "이미 사용중인 이메일 입니다.");

            throw new CustomValidationException("Duplicate email", errorMap);
        }

    }
}
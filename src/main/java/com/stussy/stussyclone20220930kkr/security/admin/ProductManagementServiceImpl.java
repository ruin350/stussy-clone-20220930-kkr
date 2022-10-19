package com.stussy.stussyclone20220930kkr.security.admin;

import com.stussy.stussyclone20220930kkr.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930kkr.dto.admin.ProductRegisterReqDto;
import com.stussy.stussyclone20220930kkr.repository.admin.ProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public interface ProductManagementServiceImpl implements ProductManagementService{

    private final ProductManagementRepository   productManagementRepository;


    @Override
    public List<CategoryResponseDto> getCategoryList() throws Exception{
        // 여기서부터
        return null;
    }
    @Override
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception{

    }
}

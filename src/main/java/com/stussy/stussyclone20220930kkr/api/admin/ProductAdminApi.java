package com.stussy.stussyclone20220930kkr.api.admin;

import com.stussy.stussyclone20220930kkr.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930kkr.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220930kkr.dto.CMRespDto;
import com.stussy.stussyclone20220930kkr.dto.admin.ProductRegisterReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class ProductAdminApi {
    @LogAspect
    @ValidAspect
    @PostMapping("/product")
    public ResponseEntity<?>registerProductMst(@Validated @RequestBody ProductRegisterReqDto productRegisterReqDto,
                                               BindingResult bindingResult){
        return ResponseEntity.created(null)
                .body(new CMRespDto<>("Register Successfully",null));
    }

    @GetMapping("/product/category")
    public ResponseEntity<?> getCategoryList(){
        return ResponseEntity.ok().body(new CMRespDto<>("Get Successfully",null));
    }
}

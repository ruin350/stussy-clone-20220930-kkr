package com.stussy.stussyclone20220930kkr.service.admin;

import com.stussy.stussyclone20220930kkr.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930kkr.dto.admin.ProductRegisterReqDto;

import java.util.List;

public interface ProductManagementService {

    public List<CategoryResponseDto> getCategoryList() throws Exception;

    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception;
}

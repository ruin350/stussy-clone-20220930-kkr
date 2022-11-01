package com.stussy.stussyclone20220930kkr.service;

import com.stussy.stussyclone20220930kkr.dto.CheckoutRespDto;
import com.stussy.stussyclone20220930kkr.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930kkr.dto.ProductRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
    public ProductRespDto getProduct(int pdtId) throws Exception;
    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;
}

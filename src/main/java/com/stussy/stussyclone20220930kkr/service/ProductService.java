package com.stussy.stussyclone20220930kkr.service;

import com.stussy.stussyclone20220930kkr.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930kkr.dto.ProductRstDto;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
    public ProductRstDto getProduct(int pdtId) throws Exception;
}

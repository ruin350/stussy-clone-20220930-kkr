package com.stussy.stussyclone20220930kkr.repository;


import com.stussy.stussyclone20220930kkr.domain.CollectionProduct;
import com.stussy.stussyclone20220930kkr.domain.PaymentProduct;
import com.stussy.stussyclone20220930kkr.domain.Product;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {

    public List<CollectionProduct> getProductList(Map<String, Object> map) throws Exception;

    public Product getProduct(int pdtId) throws Exception;
    public PaymentProduct getPaymentProduct(int pdtDtlId) throws Exception;


}

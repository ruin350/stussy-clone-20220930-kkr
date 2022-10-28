package com.stussy.stussyclone20220930kkr.service;

import com.stussy.stussyclone20220930kkr.domain.Product;
import com.stussy.stussyclone20220930kkr.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930kkr.dto.ProductRstDto;
import com.stussy.stussyclone20220930kkr.exception.CustomValidationException;
import com.stussy.stussyclone20220930kkr.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception {
        List<CollectionListRespDto> productList = new ArrayList<CollectionListRespDto>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category", category);
        map.put("index", (page - 1) * 16);

        productRepository.getProductList(map).forEach(collectionsProduct -> {
            productList.add(collectionsProduct.toDto());
        });

        return productList;
    }

    @Override
    public ProductRstDto getProduct(int pdtId) throws Exception {
        Product product = productRepository.getProduct(pdtId);
        if(product == null){
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("error", "등록되지 않은 상품입니다.");
            throw new CustomValidationException("Get Product Error", errorMap);
        }
        Map<String,List<Map<String,Object>>> pdtColors = new HashMap<String, List<Map<String,Object>>>();
        List<String> pdtImgs = new ArrayList<String>();

        product.getPdt_dtls().forEach(dtl ->{
            if(pdtColors.containsKey(dtl.getPdt_color())){
                pdtColors.put(dtl.getPdt_color(), new ArrayList<Map<String,Object>>());
            }
        });
        product.getPdt_dtls().forEach(dtl ->{
            Map<String ,Object> pdtDtlIdAndSize = new HashMap<String, Object>();
            pdtDtlIdAndSize.put("pdtDtlId",dtl.getId());
            pdtDtlIdAndSize.put("sizeId",dtl.getSize_id());
            pdtDtlIdAndSize.put("sizeName",dtl.getSize_name());
            pdtDtlIdAndSize.put("pdtStock",dtl.getPdt_stock());

            pdtColors.get(dtl.getPdt_color()).add(pdtDtlIdAndSize);
        });
        product.getPdt_imgs().forEach(img ->{
            pdtImgs.add(img.getSave_name());
        });

        ProductRstDto dto = ProductRstDto.builder()
                .pdtId(product.getId())
                .pdtName(product.getPdt_name())
                .pdtPrice(product.getPdt_price())
                .pdtSimpleInfo(product.getPdt_simple_info())
                .pdtDetailInfo(product.getPdt_detail_info())
                .pdtOptionInfo(product.getPdt_option_info())
                .pdtManagementInfo(product.getPdt_management_info())
                .pdtShippingInfo(product.getPdt_shipping_info())
                .pdtColors(pdtColors)
                .pdtImags(pdtImgs)
                .build();

        return dto;
    }
}

package com.stussy.stussyclone20220930kkr.domain;

import com.stussy.stussyclone20220930kkr.dto.admin.ProductSizeOptionReqDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionProductSize {
    private int size_id;
    private String size_name;

    public ProductSizeOptionReqDto toDto() {
        return ProductSizeOptionReqDto.builder()
                .sizeId(size_id)
                .sizeName(size_name)
                .build();
    }
}
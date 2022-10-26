package com.stussy.stussyclone20220930kkr.dto.admin;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductSizeOptionReqDto {
    private int sizeId;
    private String sizeName;
}

package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductCollectionDto {

    private List<ProductDto> productDtoList;
    private Integer totalRecords;

}
package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ProductDto {
    private String name;
    private Integer price;
    private String description;
    private Instant submissionTime;
    private String photoUrl;
}

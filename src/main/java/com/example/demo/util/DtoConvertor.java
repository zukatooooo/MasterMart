package com.example.demo.util;

import com.example.demo.dto.ProductCollectionDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Product;
import com.example.demo.model.User;

import java.util.List;

public class DtoConvertor {
    public UserDto convert(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .password(user.getPassword())
                .build();
    }
    public User convert(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .birthday(userDto.getBirthday())
                .password(userDto.getPassword())
                .build();
    }
    public ProductDto convert(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .submissionTime(product.getSubmissionTime())
                .photoUrl(product.getPhotoUrl())
                .build();
    }
    public Product convert(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .submissionTime(productDto.getSubmissionTime())
                .photoUrl(productDto.getPhotoUrl())
                .build();
    }
    public ProductCollectionDto convert(List<Product> products) {
        return ProductCollectionDto.builder()
                .productDtoList(products.stream().map(this::convert).toList())
                .totalRecords(products.size())
                .build();
    }
}

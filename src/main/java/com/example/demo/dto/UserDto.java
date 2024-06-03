package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private Instant birthday;
    private String password;
}

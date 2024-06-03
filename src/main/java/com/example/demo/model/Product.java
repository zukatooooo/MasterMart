package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private Integer price;

    @Column(name = "prod_description")
    private String description;

    @Column(name = "prod_sub_time")
    private Instant submissionTime;

    @Column(name = "prod_photo_url")
    private String photoUrl;

}

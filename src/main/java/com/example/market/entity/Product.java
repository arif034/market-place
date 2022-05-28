package com.example.market.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    @JsonProperty(value = "product_id")
    private Long productId;

    @Column(name = "product_name")
    @JsonProperty(value = "product_name")
    private String productName;

    @Column(name = "category")
    @JsonProperty(value = "category")
    private String category;

    @Column(name = "price")
    @Builder.Default
    @JsonProperty(value = "price")
    private Double price = 0.0D;

}
package com.ecommerce.ecommerce.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductRequest {
    private String code;
    private String name;
    private int quantity;
    private double price;
    private String title;
    private String description;
}

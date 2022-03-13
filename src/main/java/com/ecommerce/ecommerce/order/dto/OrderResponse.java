package com.ecommerce.ecommerce.order.dto;

import com.ecommerce.ecommerce.product.dto.ProductRequest;
import com.ecommerce.ecommerce.product.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderResponse {
    private long customer_id;
    private int quantity;
    private double price;
    private double bill_amount;
    private ProductResponse productResponse;
}

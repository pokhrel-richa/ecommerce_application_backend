package com.ecommerce.ecommerce.order.dto;

import com.ecommerce.ecommerce.product.dto.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderRequest {
    private long customer_id;
    private int quantity;
//    private ProductRequest productRequest;
}

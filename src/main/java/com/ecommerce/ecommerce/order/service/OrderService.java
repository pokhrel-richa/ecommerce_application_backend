package com.ecommerce.ecommerce.order.service;

import com.ecommerce.ecommerce.order.dto.OrderRequest;

public interface OrderService {
    public String checkProduct(OrderRequest orderRequest, long parseLong);
}

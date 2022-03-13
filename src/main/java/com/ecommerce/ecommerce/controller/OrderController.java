package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.order.dto.OrderRequest;
import com.ecommerce.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("order/{product_id}")
    public String placeOrder(@RequestBody OrderRequest orderRequest, @PathVariable("product_id") String id){
        return  orderService.checkProduct(orderRequest, Long.parseLong(id));
    }
}

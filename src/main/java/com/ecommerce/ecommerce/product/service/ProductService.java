package com.ecommerce.ecommerce.product.service;

import com.ecommerce.ecommerce.product.dto.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public String createProduct(ProductRequest productRequest);
    public List<ProductRequest> getAllProducts();
    String updateProduct(ProductRequest productRequest,long parseLong);
    String deleteProduct(long id);
}

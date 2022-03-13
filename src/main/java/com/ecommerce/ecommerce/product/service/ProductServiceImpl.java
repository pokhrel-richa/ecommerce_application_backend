package com.ecommerce.ecommerce.product.service;

import com.ecommerce.ecommerce.product.dto.ProductRequest;
import com.ecommerce.ecommerce.product.entity.Product;
import com.ecommerce.ecommerce.product.productrepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setQuantity(productRequest.getQuantity());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setTitle(productRequest.getTitle());
        productRepository.save(product);
        return "Product Created Successfully";

    }

    @Override
    public List<ProductRequest> getAllProducts() {
        List<Product> products= productRepository.findAll();
        List<ProductRequest> productRequests = new ArrayList<>();
        products.forEach(e->{
            ProductRequest productRequest = new ProductRequest();
            productRequest.setName(e.getName());
            productRequest.setPrice(e.getPrice());
            productRequest.setCode(e.getCode());
            productRequest.setDescription(e.getDescription());
            productRequest.setQuantity(e.getQuantity());
            productRequest.setTitle(e.getTitle());
            productRequests.add(productRequest);
        });
        return productRequests;
    }

    @Override
    public String updateProduct(ProductRequest productRequest, long parseLong) {
        Product product = productRepository.getById(parseLong);
        if(product == null){
            return "Product Unavailable or Doesn't Exist";
        }
        product.setTitle(productRequest.getTitle());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setCode(productRequest.getCode());
        productRepository.save(product);
        return "Product updated Successfully";

    }

    @Override
    public String deleteProduct(long id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }
}

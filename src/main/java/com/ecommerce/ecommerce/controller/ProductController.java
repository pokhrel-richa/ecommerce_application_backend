package com.ecommerce.ecommerce.controller;
import com.ecommerce.ecommerce.product.dto.ProductRequest;
import com.ecommerce.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("product/create")
    public String createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
    @GetMapping("product/all")
    public List<ProductRequest> getAllProducts(){
        return productService.getAllProducts();
    }
    @PutMapping("product/update/{id}")
    public String updateProduct(@RequestBody ProductRequest productRequest, @PathVariable("id") String id){
        return productService.updateProduct(productRequest,Long.parseLong(id));
    }
    @DeleteMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        return  productService.deleteProduct(Long.parseLong(id));
    }
}

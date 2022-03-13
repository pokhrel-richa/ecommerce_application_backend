package com.ecommerce.ecommerce.product.productrepository;

import com.ecommerce.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

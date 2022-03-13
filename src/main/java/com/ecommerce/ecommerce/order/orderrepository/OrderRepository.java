package com.ecommerce.ecommerce.order.orderrepository;

import com.ecommerce.ecommerce.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderItem,Long> {
}

package com.ecommerce.ecommerce.order.entity;

import com.ecommerce.ecommerce.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    private int quantity;
    private double price;
    private double bill_amount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

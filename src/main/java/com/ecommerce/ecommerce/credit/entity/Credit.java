package com.ecommerce.ecommerce.credit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="CREDIT")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Column(name = "CREDIT_LIMIT")
    private double limit;
}

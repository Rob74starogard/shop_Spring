package com.shop.shop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ORDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "quantityOrdered")
    private int quantityOrdered;

    public OrderEntity(Long id, String productName, int quantityOrdered) {
        this.id = id;
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }
}



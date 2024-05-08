package com.shop.shop.model;

import lombok.Getter;

@Getter
public class OrderDto {
    private Long id;
    private String productName;
    private int quantityOrdered;

    public OrderDto(Long id, String productName, int quantityOrdered) {
        this.id = id;
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }
}


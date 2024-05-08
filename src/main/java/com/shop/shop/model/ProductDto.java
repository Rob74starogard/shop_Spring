package com.shop.shop.model;


import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    private String name;
    private int quantity;

    public ProductDto(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }


}

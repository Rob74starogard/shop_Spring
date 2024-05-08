package com.shop.shop.model;


import lombok.Getter;

@Getter
public class ProductDto {
    private int id;
    private String name;
    private int quantity;

    public ProductDto(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }


}

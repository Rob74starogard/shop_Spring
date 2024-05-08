package com.shop.shop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "PRODUCT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "QUANTITY")
    private int quantity;

    public ProductEntity(int id,String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}

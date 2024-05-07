package com.shop.shop.service;

import com.shop.shop.entity.ProductEntity;
import com.shop.shop.mapper.MapperInTwoDirections;
import com.shop.shop.model.ProductDto;
import com.shop.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class Productmanager {
    private ProductRepository productRepository;
    private MapperInTwoDirections mapperInTwoDirections;

    public Productmanager(ProductRepository productRepository, MapperInTwoDirections mapperInTwoDirections) {
        this.productRepository = productRepository;
        this.mapperInTwoDirections = mapperInTwoDirections;
    }

    public void productAdd(ProductDto productDto) {
        ProductEntity productEntity = mapperInTwoDirections.toEntity(productDto);
        productRepository.save(productEntity);
    }
}

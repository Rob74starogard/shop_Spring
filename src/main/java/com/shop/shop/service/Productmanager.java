package com.shop.shop.service;

import com.shop.shop.entity.ProductEntity;
import com.shop.shop.mapper.ProductMapperInTwoDirections;
import com.shop.shop.model.ProductDto;
import com.shop.shop.repository.ProductRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productmanager {
    @Getter
    private ProductRepository productRepository;
    private ProductMapperInTwoDirections mapperInTwoDirections;

    public Productmanager(ProductRepository productRepository, ProductMapperInTwoDirections mapperInTwoDirections) {
        this.productRepository = productRepository;
        this.mapperInTwoDirections = mapperInTwoDirections;
    }

    public void productAdd(ProductDto productDto) {
        ProductEntity productEntity = mapperInTwoDirections.toEntity(productDto);
        productRepository.save(productEntity);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(mapperInTwoDirections::fromEntity)
                .toList();
    }
}

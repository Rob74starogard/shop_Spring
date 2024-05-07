package com.shop.shop.mapper;

import com.shop.shop.entity.ProductEntity;
import com.shop.shop.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class MapperInTwoDirections {
    public ProductDto fromEntity(ProductEntity productEntity) {
        return new ProductDto(productEntity.getName(), productEntity.getQuantity());
    }

    public ProductEntity toEntity(ProductDto productDto) {
        return new ProductEntity(productDto.getName(), productDto.getQuantity());
    }
}

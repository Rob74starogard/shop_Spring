package com.shop.shop.mapper;

import com.shop.shop.entity.OrderEntity;
import com.shop.shop.entity.ProductEntity;
import com.shop.shop.model.OrderDto;
import com.shop.shop.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperInTwoDirections {
    public OrderDto toOrderEntity(OrderEntity orderEntity) {
        return new OrderDto(orderEntity.getId(),orderEntity.getProductName(),orderEntity.getQuantityOrdered());
    }
    public OrderEntity toOrderEntity(OrderDto orderDto) {
        return new OrderEntity(orderDto.getId(), orderDto.getProductName(), orderDto.getQuantityOrdered());
    }

}

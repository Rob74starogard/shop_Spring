package com.shop.shop.service;

import com.shop.shop.entity.OrderEntity;
import com.shop.shop.mapper.OrderMapperInTwoDirections;
import com.shop.shop.model.OrderDto;
import com.shop.shop.repository.OrderRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ordermanager {
    @Getter
    private OrderRepository orderRepository;
    private OrderMapperInTwoDirections orderMapperInTwoDirections;

    public Ordermanager(OrderRepository orderRepository, OrderMapperInTwoDirections orderMapperInTwoDirections) {
        this.orderRepository = orderRepository;
        this.orderMapperInTwoDirections = orderMapperInTwoDirections;
    }

    public void orderAdd(OrderDto orderDto) {
        OrderEntity orderEntity = orderMapperInTwoDirections.toOrderEntity(orderDto);
        orderRepository.save(orderEntity);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapperInTwoDirections::toOrderEntity)
                .toList();
    }
}


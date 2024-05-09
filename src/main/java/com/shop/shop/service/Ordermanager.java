package com.shop.shop.service;

import com.shop.shop.entity.OrderEntity;
import com.shop.shop.entity.ProductEntity;
import com.shop.shop.mapper.OrderMapperInTwoDirections;
import com.shop.shop.mapper.ProductMapperInTwoDirections;
import com.shop.shop.model.OrderDto;
import com.shop.shop.model.ProductDto;
import com.shop.shop.repository.OrderRepository;
import com.shop.shop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ordermanager {
    @Getter
    Long i = 0L;
    private OrderRepository orderRepository;
    private OrderMapperInTwoDirections orderMapperInTwoDirections;
    private Productmanager productmanager;

    public Ordermanager(OrderRepository orderRepository, ProductRepository productRepository, OrderMapperInTwoDirections orderMapperInTwoDirections, ProductMapperInTwoDirections productMapperInTwoDirections) {
        this.orderRepository = orderRepository;

        this.orderMapperInTwoDirections = orderMapperInTwoDirections;
    }


    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapperInTwoDirections::toOrderEntity)
                .toList();
    }

    @Transactional
    public void orderCreate(Long id, int quantity) {
        i++;
        ProductEntity searched = productmanager.getById(id);
        productmanager.deacreseQuantity(searched, quantity);
        OrderDto newOrder = new OrderDto(i, searched.getName(), quantity);
        orderAdd(newOrder);
    }

    private void orderAdd(OrderDto orderDto) {
        OrderEntity orderEntity = orderMapperInTwoDirections.toOrderEntity(orderDto);
        orderRepository.save(orderEntity);
    }
}


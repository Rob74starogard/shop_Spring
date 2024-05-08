package com.shop.shop;

import com.shop.shop.model.OrderDto;
import com.shop.shop.service.Ordermanager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final Ordermanager ordermanager;


    @PostMapping
    public void addOrder(@RequestBody OrderDto orderDto){
        ordermanager.orderAdd(orderDto);
    }
    @GetMapping("/getall")
    public List<OrderDto> getOrders(){
        return ordermanager.getAllOrders();
    }
}

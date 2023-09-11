package com.example.furniture.controller;

import com.example.furniture.model.Order;
import com.example.furniture.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public Order addOrderAndUpdate(@RequestBody Order order) {
        System.out.println(order.toString());
        return orderService.addAndUpdateOrder(order);
    }

    @GetMapping("/findByUserId/{id}")
    public List<Order> findOrderByUserId(@PathVariable("id") Long id) {
        return orderService.findOrderUserId(id);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrder();
    }
}


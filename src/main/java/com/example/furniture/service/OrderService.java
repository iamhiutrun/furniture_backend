package com.example.furniture.service;

import com.example.furniture.model.Order;
import com.example.furniture.repository.CartRepository;
import com.example.furniture.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order addAndUpdateOrder(Order order){
        Order newOrder = order;
        if(newOrder.getOrderDate()== null){
            order.setOrderDate(new Date());
        }
        if(order.getOrderId()!= null){
            Optional<Order> optionalOrder = orderRepository.findById(order.getOrderId());
            if(optionalOrder.isPresent()){
                newOrder = optionalOrder.get();
                newOrder.setStatus(order.getStatus());;
            }
        }
        return orderRepository.save(newOrder);
    }

    public List<Order> findOrderUserId(Long userId){
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
}
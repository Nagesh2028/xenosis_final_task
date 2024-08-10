package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.model.Order;
import com.example.ecommerceplatform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

   
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

 
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

  
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, String status) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null; 
    }

    

 
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}


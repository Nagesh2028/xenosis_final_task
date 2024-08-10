package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.model.OrderItem;
import com.example.ecommerceplatform.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    // Get all order items
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Get an order item by ID
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    // Add a new order item
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an existing order item
    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItem = orderItemRepository.findById(id);
        if (existingOrderItem.isPresent()) {
            OrderItem orderItem = existingOrderItem.get();
            orderItem.setQuantity(updatedOrderItem.getQuantity());
            orderItem.setPrice(updatedOrderItem.getPrice());
            // Update other fields as needed
            return orderItemRepository.save(orderItem);
        } else {
            return null; // or throw an exception
        }
    }

    // Delete an order item by ID
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}



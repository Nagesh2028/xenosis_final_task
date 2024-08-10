package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
    List<Order> findByUserId(Long userId);
}

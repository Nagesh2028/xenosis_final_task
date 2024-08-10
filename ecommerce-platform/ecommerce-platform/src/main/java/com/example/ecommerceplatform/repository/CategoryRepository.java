package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
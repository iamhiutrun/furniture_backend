package com.example.furniture.repository;

import com.example.furniture.model.Cart;
import com.example.furniture.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional custom methods can be defined here if needed
}

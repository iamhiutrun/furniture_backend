package com.example.furniture.repository;

import com.example.furniture.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional custom methods can be defined here if needed
    void deleteByUserId(Long userId);
}

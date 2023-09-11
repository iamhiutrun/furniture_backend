package com.example.furniture.repository;

import com.example.furniture.model.Payment;
import com.example.furniture.model.Product;
import com.example.furniture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional custom methods can be defined here if needed
    List<Product> findByCategoryId(int categoryId);
    @Query(value = "SELECT * FROM products p WHERE p.name ILIKE %:name%", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);
    @Query(value = "SELECT * FROM products p WHERE p.product_id IN :ids", nativeQuery = true)
    List<Product> findByIds(@Param("ids") List<Long> ids);
}

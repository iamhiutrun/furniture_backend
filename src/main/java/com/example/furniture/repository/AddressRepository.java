package com.example.furniture.repository;

import com.example.furniture.model.Address;
import com.example.furniture.model.Cart;
import com.example.furniture.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Additional custom methods can be defined here if needed
    @Query(value = "SELECT * FROM Addresses p WHERE p.user_id = :user_id", nativeQuery = true)
    List<Address> findByUserId(@Param("user_id") Long userId);
}

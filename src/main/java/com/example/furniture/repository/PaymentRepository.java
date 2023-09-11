package com.example.furniture.repository;

import com.example.furniture.model.Address;
import com.example.furniture.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Additional custom methods can be defined here if needed

    @Query(value = "SELECT * FROM payment_methods p WHERE p.user_id = :user_id", nativeQuery = true)
    List<Payment> findByUserId(@Param("user_id") Long userId);
}

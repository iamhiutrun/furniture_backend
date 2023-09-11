package com.example.furniture.repository;

import com.example.furniture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom methods can be defined here if needed
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}

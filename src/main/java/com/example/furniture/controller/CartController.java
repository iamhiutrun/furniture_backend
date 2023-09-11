package com.example.furniture.controller;

import com.example.furniture.model.Cart;
import com.example.furniture.model.User;
import com.example.furniture.service.CartService;
import com.example.furniture.service.UserService;
import com.example.furniture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;


    @PostMapping
    public Cart addItemToCart(@RequestBody Cart cart) {
        return cartService.addItemToCard(cart);
    }

    @GetMapping("/{id}")
    public Cart findCartById(@PathVariable("id") Long id) {
        System.out.println(id);
        return cartService.findCartById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartById(@PathVariable("id") Long id) {
        cartService.removeCart(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Xoá giỏ hàng thành công", HttpStatus.OK));
    }
}


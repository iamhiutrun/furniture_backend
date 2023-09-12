package com.example.furniture.service;

import com.example.furniture.model.Cart;
import com.example.furniture.model.Product;
import com.example.furniture.repository.CartRepository;
import com.example.furniture.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addItemToCard(Cart cart){
        Cart newCart = cart;
        if(cart.getCartId() != null) {
            Optional<Cart> cartOptional = cartRepository.findById(cart.getCartId());
            if (cartOptional.isPresent()) {
                newCart = cartOptional.get();
                newCart.setProductId(cart.getProductId());
                newCart.setQuantity(cart.getQuantity());
                if(cart.getColor() != null){
                    newCart.setColor(cart.getColor());
                }
            }
            cartRepository.deleteByUserId(cart.getUserId());
        }
        return cartRepository.save(newCart);
    }

    public Cart findCartById(Long cartId){
        return cartRepository.findById(cartId).get();
    }

    public void removeCart(Long cartId){
        cartRepository.deleteById(cartId);
    }
}
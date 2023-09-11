package com.example.furniture.model;

import jakarta.persistence.*;

@Table(name = "cart_items")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "color")
    private String color;

    public Cart(Long productId, int quantity, String color) {
        this.productId = productId;
        this.quantity = quantity;
        this.color = color;
    }

    public Cart(){

    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                '}';
    }
}

package com.example.furniture.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "default_payment_id")
    private Integer defaultPaymentId;

    @Column(name = "default_shipping_id")
    private Integer defaultShippingId;

    @Column(name = "favourite_list")
    private String favouriteList;

    @Column(name = "card_list")
    private String cardList;

    @Column(name = "password", nullable = false)
    private String password;


    public User( String name, String email, Integer defaultPaymentId, Integer defaultShippingId, String favouriteList, String cardList, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.defaultPaymentId = defaultPaymentId;
        this.defaultShippingId = defaultShippingId;
        this.favouriteList = favouriteList;
        this.cardList = cardList;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDefaultPaymentId() {
        return defaultPaymentId;
    }

    public void setDefaultPaymentId(Integer defaultPaymentId) {
        this.defaultPaymentId = defaultPaymentId;
    }

    public Integer getDefaultShippingId() {
        return defaultShippingId;
    }

    public void setDefaultShippingId(Integer defaultShippingId) {
        this.defaultShippingId = defaultShippingId;
    }

    public String getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(String favouriteList) {
        this.favouriteList = favouriteList;
    }

    public String getCardList() {
        return cardList;
    }

    public void setCardList(String cardList) {
        this.cardList = cardList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", defaultPaymentId=" + defaultPaymentId +
                ", defaultShippingId=" + defaultShippingId +
                ", favouriteList='" + favouriteList + '\'' +
                ", cardList='" + cardList + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
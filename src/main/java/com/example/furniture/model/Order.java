package com.example.furniture.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date", nullable = true)
    private Date orderDate;

    @Column(name = "order_detail")
    private String orderDetail;

    @Column(name = "status")
    private String status;

    @Column(name = "user_id")
    private Long userId;

    // Constructors, getters, and setters

    public Order() {
    }

    public Order(Date orderDate, String orderDetail, String status, Long userId) {
        this.orderDate = orderDate;
        this.orderDetail = orderDetail;
        this.status = status;
        this.userId = userId;
    }

    // Getters and setters

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderDetails=" + orderDetail +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}

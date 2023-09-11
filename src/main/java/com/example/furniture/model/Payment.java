package com.example.furniture.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "payment_methods")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;
    @Column(name = "cardholder_name")
    private String cardholderName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cvv")
    private int cvv;
    private int month;
    private int year;
    @Column(name = "user_id")
    private int userId;

    public Payment(String cardholderName, String cardNumber, int cvv, int month, int year, int userId) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
        this.userId = userId;
    }

    public Payment(){

    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", cardholderName='" + cardholderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv=" + cvv +
                ", month=" + month +
                ", year=" + year +
                ", userId=" + userId +
                '}';
    }
}

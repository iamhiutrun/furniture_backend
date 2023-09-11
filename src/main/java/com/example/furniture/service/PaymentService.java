package com.example.furniture.service;

import com.example.furniture.model.Payment;
import com.example.furniture.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addAndUpdateAddress(Payment payment){
        Payment newPayment = payment;
        if(newPayment.getPaymentId() != null) {
            Optional<Payment> paymentOptional = paymentRepository.findById(payment.getPaymentId());
            if (paymentOptional.isPresent()) {
                newPayment = paymentOptional.get();
                newPayment.setCardholderName(payment.getCardholderName());
                newPayment.setCardNumber(payment.getCardNumber());
                newPayment.setCvv(payment.getCvv());
                newPayment.setMonth(payment.getMonth());
                newPayment.setYear(payment.getYear());
                newPayment.setUserId(payment.getUserId());
            }
        }
        return paymentRepository.save(newPayment);
    }

    public Payment findPaymentById(Long paymentId){
        return paymentRepository.findById(paymentId).get();
    }

    public List<Payment> findPaymentUserId(Long userId){
        return paymentRepository.findByUserId(userId);
    }
}
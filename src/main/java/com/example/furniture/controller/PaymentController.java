package com.example.furniture.controller;

import com.example.furniture.model.Payment;
import com.example.furniture.service.PaymentService;
import com.example.furniture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;


    @PostMapping
    public Payment addAndUpdatePayment(@RequestBody Payment payment) {
        System.out.println(payment.toString());
        return paymentService.addAndUpdateAddress(payment);
    }

    @GetMapping("/{id}")
    public Payment findAddressById(@PathVariable("id") Long id) {
        return paymentService.findPaymentById(id);
    }

    @GetMapping("/findByUserId/{id}")
    public List<Payment> findAddressByUserId(@PathVariable("id") Long id) {
        return paymentService.findPaymentUserId(id);
    }

}


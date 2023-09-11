package com.example.furniture.controller;

import com.example.furniture.model.Address;
import com.example.furniture.model.Cart;
import com.example.furniture.model.User;
import com.example.furniture.service.AddressService;
import com.example.furniture.service.CartService;
import com.example.furniture.service.UserService;
import com.example.furniture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;


    @PostMapping
    public Address addAndUpdateAddress(@RequestBody Address address) {
        return addressService.addAndUpdateAddress(address);
    }

    @GetMapping("/{id}")
    public Address findAddressById(@PathVariable("id") Long id) {
        return addressService.findAddressById(id);
    }

    @GetMapping("/findByUserId/{id}")
    public List<Address> findAddressByUserId(@PathVariable("id") Long id) {
        return addressService.findAddressUserId(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Xoá địa chỉ thành công", HttpStatus.OK));
    }

}


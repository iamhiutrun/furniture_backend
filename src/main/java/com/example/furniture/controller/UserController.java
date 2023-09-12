package com.example.furniture.controller;

import com.example.furniture.model.Payment;
import com.example.furniture.model.User;
import com.example.furniture.repository.PaymentRepository;
import com.example.furniture.repository.UserRepository;
import com.example.furniture.service.UserService;
import com.example.furniture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping
//public class UserController {
//    private final UserRepository userRepository;
//    private final PaymentRepository paymentRepository;
//
//    public UserController(UserRepository userRepository, PaymentRepository paymentRepository) {
//        this.userRepository = userRepository;
//        this.paymentRepository = paymentRepository;
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        System.out.println(user);
//        return userRepository.save(user);
//    }
//
//    @PostMapping("/payment")
//    public Payment createPayment(@RequestBody Payment payment) {
//        System.out.println(payment);
//        return paymentRepository.save(payment);
//    }
//
//    @GetMapping
//    public String createUser() {
//        return "userRepository.save(user);";
//    }
//}

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userService.register(user) == null){
            ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Đăng ký thành công", HttpStatus.OK, userService.register(user)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Tài khoản đã có người đăng ký", HttpStatus.FOUND));
    }

    @PostMapping("/login")
    public ResponseEntity<?> auth(@RequestBody User request) {
        User user = userService.login(request);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Đăng nhập thất bại", HttpStatus.UNAUTHORIZED));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Đăng nhập thành công", HttpStatus.OK, user));
        }
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<?> updateInformation(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Cập nhật thông tin thành công", HttpStatus.OK, userService.updateInformation(user)));
    }

    @PostMapping("/favourite/{id}")
    public ResponseEntity<?> favourite(@RequestBody User user, @PathVariable("id") String id) {
        if (userService.favourite(user, id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Đã cập nhật", HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<User>("Không tìm thấy sản phẩm", HttpStatus.OK));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<List<User>>("Danh sách User", HttpStatus.OK, userService.findAll()));
    }

}


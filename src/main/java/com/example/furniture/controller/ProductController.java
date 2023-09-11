package com.example.furniture.controller;

import com.example.furniture.model.Product;
import com.example.furniture.model.ProductIdList;
import com.example.furniture.model.User;
import com.example.furniture.service.ProductService;
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
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{category_id}")
    public List<Product> getProductsByCategory(@PathVariable("category_id") int categoryId){
        return productService.getProductByCategory(categoryId);
    }

    @GetMapping("/findProduct/{query}")
    public List<Product> getProductsByCategory(@PathVariable("query") String query){
        return productService.findProductsByName(query);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        System.out.println(product.toString());
        return productService.createProduct(product);
    }

    @PostMapping("/findByIds")
    public List<Product> getProductsByIds(@RequestBody ProductIdList idList){
        return productService.getProductsByIds(idList.getIds());
    }

    @GetMapping("/find/{id}")
    public Product getProductsByCategory(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }

}


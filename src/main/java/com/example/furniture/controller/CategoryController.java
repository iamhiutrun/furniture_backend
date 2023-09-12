package com.example.furniture.controller;

import com.example.furniture.model.Cart;
import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.User;
import com.example.furniture.service.CartService;
import com.example.furniture.service.CategoryService;
import com.example.furniture.service.UserService;
import com.example.furniture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("Xoá sản phẩm thành công");
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<List<Category>>("Danh sach category", HttpStatus.OK, categoryService.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> createAndUpdate(@RequestBody Category category) {
        if (category.getCategoryId() == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<Category>("Tạo thành công", HttpStatus.OK, categoryService.createAndUpdateCategory(category)));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<Category>("Cập nhật thành công", HttpStatus.OK, categoryService.createAndUpdateCategory(category)));
        }
    }
}


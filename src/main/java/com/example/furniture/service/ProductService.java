package com.example.furniture.service;

import com.example.furniture.model.Product;
import com.example.furniture.model.User;
import com.example.furniture.repository.ProductRepository;
import com.example.furniture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductByCategory(int category){
        if(category == 0){
            return  productRepository.findAll();
        }
        return productRepository.findByCategoryId(category);
    }
    public List<Product> findProductsByName(String name){
        return productRepository.findByName(name);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProductsByIds(List<Long> ids){
        return productRepository.findByIds(ids);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

}
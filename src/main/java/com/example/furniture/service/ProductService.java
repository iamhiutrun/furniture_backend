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
        Product newProduct = product;
        if(product.getProductId() != null){
           Optional<Product> optionalProduct =  productRepository.findById(product.getProductId());
           if(optionalProduct.isPresent()){
               newProduct = optionalProduct.get();
               newProduct.setCategoryId(product.getCategoryId());
               newProduct.setCreatedAt(product.getCreatedAt());
               newProduct.setName(product.getName());
               newProduct.setDescription(product.getDescription());
               newProduct.setPrice(product.getPrice());
               if(product.getImagesList() !=null) {
                   newProduct.setImagesList(product.getImagesList());
               }
               newProduct.setColorsList(product.getColorsList());
           }

        }
        return productRepository.save(newProduct);
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public List<Product> getProductsByIds(List<Long> ids){
        return productRepository.findByIds(ids);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

}
package com.example.furniture.service;
import com.example.furniture.model.Category;
import com.example.furniture.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createAndUpdateCategory(Category category){
        Category newCategory = category;
        if(category.getCategoryId() != null){
            Optional<Category> optionalCategory = categoryRepository.findById(category.getCategoryId());
            if(optionalCategory.isPresent()){
                newCategory.setCategoryName(category.getCategoryName());
            }
        }
        return categoryRepository.save(newCategory);
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}

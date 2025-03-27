package com.avanthi.eshop.rest.api.service.impl;

import com.avanthi.eshop.rest.api.entity.Category;
import com.avanthi.eshop.rest.api.exception.ResourceNotFoundException;
import com.avanthi.eshop.rest.api.repository.CategoryRepository;
import com.avanthi.eshop.rest.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category","categoryId",id));
        return category;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }



    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category","categoryId",id));
        existingCategory.setName(category.getName());
        existingCategory.setImageUrl(category.getImageUrl());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category","categoryId",id));
        categoryRepository.delete(category);

    }
}

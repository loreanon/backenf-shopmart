package com.avanthi.eshop.rest.api.service;

import com.avanthi.eshop.rest.api.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(Long id);
    Category addCategory(Category category);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Long id);
}

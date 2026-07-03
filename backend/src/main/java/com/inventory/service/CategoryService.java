package com.inventory.service;

import com.inventory.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category updateCategory(Long categoryId, Category category);

    void deleteCategory(Long categoryId);
}
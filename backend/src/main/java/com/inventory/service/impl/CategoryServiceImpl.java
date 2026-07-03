package com.inventory.service.impl;

import com.inventory.entity.Category;
import com.inventory.repository.CategoryRepository;
import com.inventory.service.CategoryService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {

        Category existingCategory = getCategoryById(categoryId);

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category = getCategoryById(categoryId);

        categoryRepository.delete(category);
    }
}
package com.backsoul.category.services;

import java.util.List;
import java.util.Optional;

import com.backsoul.category.model.Category;

public interface CategoryService {
    public Category createCategory(String userId, String name);

    public List<Category> findByUserId(String userId);

    public Category findById(String categoryId);
}

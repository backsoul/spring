package com.backsoul.category.services;

import java.util.List;

import com.backsoul.category.model.Category;
import com.backsoul.category.model.CategoryChart;

public interface CategoryService {
    public Category createCategory(String userId, String name, String color);

    public List<Category> findByUserId(String userId);

    public Category findById(String categoryId);

    public List<CategoryChart> categoriesReport(String userId);

}

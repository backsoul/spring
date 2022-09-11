package com.backsoul.category.services;

import java.util.List;
import java.util.Optional;

import com.backsoul.category.model.Category;

public interface CategoryService {
    public Category createCategory(String userId, String name);

    public List<Optional<Category>> findByUserId(String userId);
}

package com.backsoul.category.services;

import com.backsoul.category.model.Category;
import com.backsoul.category.repository.CategoryRepository;
import com.backsoul.wallet.services.WalletServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    WalletServiceImpl walletService;

    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String userId, String name) {
        Category category = new Category();
        category.setName(name);
        category.setUserId(userId);
        Category _category = categoryRepository.save(category);
        return _category;
    }

    @Override
    public List<Optional<Category>> findByUserId(String userId) {
        return categoryRepository.findByuserId(userId);
    }
}

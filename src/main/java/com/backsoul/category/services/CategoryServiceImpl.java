package com.backsoul.category.services;

import com.backsoul.category.model.Category;
import com.backsoul.category.model.CategoryChart;
import com.backsoul.category.repository.CategoryRepository;
import com.backsoul.transaction.models.Transaction;
import com.backsoul.transaction.repository.TransactionRepository;
import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.repository.WalletRepository;
import com.backsoul.wallet.services.WalletServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    WalletServiceImpl walletService;

    private final CategoryRepository categoryRepository;

    private final TransactionRepository transactionRepository;

    private final WalletRepository walletRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository, TransactionRepository transactionRepository,
            WalletRepository walletRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public Category createCategory(String userId, String name, String color) {
        Category category = new Category();
        category.setName(name);
        category.setUserId(userId);
        category.setColor(color);
        Category _category = categoryRepository.save(category);
        return _category;
    }

    @Override
    public List<Category> findByUserId(String userId) {
        return categoryRepository.findByuserId(userId);
    }

    @Override
    public Category findById(String categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<CategoryChart> categoriesReport(String userId) {
        List<Category> categories = categoryRepository.findByuserId(userId);
        CategoryChart categoriesChart = new CategoryChart();
        categoriesChart.setupMonths(categories);

        Wallet wallet = walletRepository.findByuserId(userId).get();
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findByWalletId(wallet.getId());
        for (var transaction : transactions) {
            int amount = transaction.getAmount()
                    + categoriesChart.getCategory(transaction.getCategory().getName()).getAmount();
            categoriesChart.setAmountCategory(transaction.getCategory().getName(), amount);
            categoriesChart.setColorCategory(transaction.getCategory().getName(), transaction.getCategory().getColor());
        }
        return categoriesChart.categoriesChart;
    }

}

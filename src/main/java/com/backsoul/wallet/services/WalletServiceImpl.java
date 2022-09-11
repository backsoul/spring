package com.backsoul.wallet.services;

import com.backsoul.category.model.Category;
import com.backsoul.category.repository.CategoryRepository;
import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.repository.WalletRepository;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final CategoryRepository categoryRepository;

    WalletServiceImpl(WalletRepository walletRepository, CategoryRepository categoryRepository) {
        this.walletRepository = walletRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Wallet> getWallet(String userId) {
        return walletRepository.findByuserId(userId);
    }

    @Override
    public int salaryAnual(int salary) {
        return salary * 12;
    }

    @Override
    public String createWallet(String userId) {
        try {
            Optional<Wallet> findWallet = walletRepository.findByuserId(userId);
            Boolean userIdHaveWallet = findWallet.isPresent();
            if (!userIdHaveWallet) {
                // Create object wallet
                Wallet wallet = new Wallet();
                wallet.setUserId(userId);
                // Save wallet object in repository
                Wallet _wallet = walletRepository.save(wallet);
                CreateCategoriesBase(userId);
                return _wallet.getId();
            } else {
                return findWallet.get().getId();
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Error al crear la wallet";
        }
    }

    @Override
    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).get();
    }

    @Override
    public void CreateCategoriesBase(String userId) {
        Category category1 = new Category();
        category1.setUserId(userId);
        category1.setName("Internet");
        this.categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setUserId(userId);
        category2.setName("Comida");
        this.categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setUserId(userId);
        category3.setName("Creditos");
        this.categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setUserId(userId);
        category4.setName("Otros");
        this.categoryRepository.save(category4);
    }
}

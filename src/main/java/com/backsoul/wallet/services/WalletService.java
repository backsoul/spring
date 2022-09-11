package com.backsoul.wallet.services;

import java.util.Optional;
import com.backsoul.wallet.model.Wallet;

public interface WalletService {
    public Optional<Wallet> getWallet(String walletId);

    public String createWallet(String userId);

    public int salaryAnual(int salary);

    public Wallet getWalletById(String id);

    public void CreateCategoriesBase(String userId);

}

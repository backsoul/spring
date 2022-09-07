package com.backsoul.finance.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backsoul.finance.models.Wallet;

public interface WalletService {
    /**
     * @return
     */
    public List<Wallet> getWallets();

    public ResponseEntity<Wallet> createWallet();

    public int salaryAnual(int salary);

    public Wallet getWalletById(String id);
}

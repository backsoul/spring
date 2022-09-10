package com.backsoul.transaction.services;

import com.backsoul.transaction.repositories.TransactionRepository;
import com.backsoul.wallet.model.Wallet;

import org.springframework.stereotype.Service;

import com.backsoul.transaction.models.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(String walletId) {
        // Wallet wallet = walletService.getWalletById(walletId);
        Transaction transaction = new Transaction();
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        transaction.setWallet(wallet);
        Transaction _transaction = transactionRepository.save(transaction);
        return _transaction;
    }
}

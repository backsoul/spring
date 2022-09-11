package com.backsoul.transaction.services;

import com.backsoul.transaction.repositories.TransactionRepository;
import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.services.WalletServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backsoul.transaction.models.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    WalletServiceImpl walletService;

    private final TransactionRepository transactionRepository;

    TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(String userId, int amount) {
        Transaction transaction = new Transaction();
        Wallet wallet = walletService.getWallet(userId).get();
        transaction.setWallet(wallet);
        transaction.setAmount(amount);
        Transaction _transaction = transactionRepository.save(transaction);
        return _transaction;
    }
}

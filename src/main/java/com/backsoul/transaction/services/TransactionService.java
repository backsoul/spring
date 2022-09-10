package com.backsoul.transaction.services;

import com.backsoul.transaction.models.Transaction;

public interface TransactionService {
    public Transaction createTransaction(String walletId);
}

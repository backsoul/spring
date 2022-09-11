package com.backsoul.transaction.services;

import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.services.WalletServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backsoul.category.model.Category;
import com.backsoul.category.services.CategoryServiceImpl;
import com.backsoul.move.model.Move;
import com.backsoul.move.services.MoveServiceImpl;
import com.backsoul.transaction.models.Transaction;
import com.backsoul.transaction.models.TransactionReportMonth;
import com.backsoul.transaction.models.TypeMove;
import com.backsoul.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    WalletServiceImpl walletServiceImpl;

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @Autowired
    MoveServiceImpl moveServiceImpl;

    private final TransactionRepository transactionRepository;

    TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(String userId, int amount, String description, String categoryId,
            String moveId, java.sql.Timestamp date) {
        Transaction transaction = new Transaction();
        Wallet wallet = walletServiceImpl.getWallet(userId).get();
        Category category = categoryServiceImpl.findById(categoryId);
        Move move = moveServiceImpl.findById(moveId);
        transaction.setWallet(wallet);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setCategory(category);
        transaction.setMove(move);
        transaction.setDate(date);
        Transaction _transaction = transactionRepository.save(transaction);
        return _transaction;
    }

    @Override
    public List<Transaction> getTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public List<TransactionReportMonth> getTransactionReportMonth(String userId) {
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
        List<TransactionReportMonth> transactionsReportMonth = new ArrayList<TransactionReportMonth>();
        TransactionReportMonth transactionReportMonth = new TransactionReportMonth();
        transactionReportMonth.setTotal(1000);
        transactionsReportMonth.add(transactionReportMonth);
        return transactionsReportMonth;
    }
}

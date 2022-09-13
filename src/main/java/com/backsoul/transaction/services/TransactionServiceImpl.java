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
            String moveId, java.sql.Timestamp date, Boolean isRecurrent, String month) {
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
        transaction.setRecurrent(isRecurrent);
        transaction.setMonth(month);
        Transaction _transaction = transactionRepository.save(transaction);
        return _transaction;
    }

    @Override
    public List<Transaction> getTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public List<TransactionReportMonth> getTransactionReportMonth(String userId) {
        TransactionReportMonth reportMonth = new TransactionReportMonth();
        reportMonth.setupMonths();
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
        for (var transaction : transactions) {
            int amount = 0;
            if (transaction.getMove().getName().contains("Ingreso")) {
                amount = reportMonth.getMonthByName(transaction.getMonth()).getTotal() + transaction.getAmount();
            }
            if (transaction.getMove().getName().contains("Egreso")) {
                amount = transaction.getAmount() - reportMonth.getMonthByName(transaction.getMonth()).getTotal();
            }

            if (transaction.getMove().getName().contains("Retiro")) {
                amount = transaction.getAmount() - reportMonth.getMonthByName(transaction.getMonth()).getTotal();
            }

            if (transaction.getMove().getName().contains("Transferencia")) {
                amount = transaction.getAmount() - reportMonth.getMonthByName(transaction.getMonth()).getTotal();
            }
            reportMonth.setAmountMonth(transaction.getMonth(), amount);
        }
        return reportMonth.months;
    }

    @Override
    public List<TransactionReportMonth> getTransactionReportEntries(String userId, String MoveId) {
        TransactionReportMonth reportMonth = new TransactionReportMonth();
        reportMonth.setupMonths();
        List<Transaction> transactions = (List<Transaction>) transactionRepository
                .findTransactionByMoveId(MoveId);
        for (var transaction : transactions) {
            reportMonth.setAmountMonth(transaction.getMonth(), transaction.getAmount());
        }
        return reportMonth.months;
    }

}

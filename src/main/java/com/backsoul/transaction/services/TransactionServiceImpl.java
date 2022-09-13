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
import com.backsoul.move.repository.MoveRepository;
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

    private final MoveRepository moveRepository;

    TransactionServiceImpl(TransactionRepository transactionRepository, MoveRepository moveRepository) {
        this.transactionRepository = transactionRepository;
        this.moveRepository = moveRepository;
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
    public List<TransactionReportMonth> getTransactionReport(String userId, String moveId) {
        TransactionReportMonth reportMonth = new TransactionReportMonth();
        reportMonth.setupMonths();
        Move move = moveRepository.findFirstById(moveId);
        System.out.println("Move name: " + move.getName());
        List<Transaction> transactions = (List<Transaction>) transactionRepository
                .findAllByMove(moveId);
        for (var transaction : transactions) {
            System.out.println("Transaction " + transaction.getMonth() + " is " + transaction.getAmount());
            reportMonth.setAmountMonth(transaction.getMonth(), transaction.getAmount());
        }
        return reportMonth.months;
    }

}

package com.backsoul.transaction.services;

import java.util.List;

import com.backsoul.transaction.models.Transaction;
import com.backsoul.transaction.models.TransactionReportMonth;

public interface TransactionService {
    public Transaction createTransaction(String walletId, int amount, String description, String categoryId,
            String moveId, java.sql.Timestamp date, Boolean isRecurrent, String month);

    public List<Transaction> getTransactions();

    public List<TransactionReportMonth> getTransactionReportMonth(String userId);

    public List<TransactionReportMonth> getTransactionReportEntries(String userId, String MoveId);

}

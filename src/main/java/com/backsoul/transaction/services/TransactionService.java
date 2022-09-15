package com.backsoul.transaction.services;

import java.util.List;

import com.backsoul.transaction.models.Transaction;
import com.backsoul.transaction.models.TransactionReportMonth;

public interface TransactionService {
    public Transaction createTransaction(String walletId, int amount, String description, String categoryId,
            String moveId, java.sql.Timestamp date, Boolean isRecurrent, String month);

    public List<Transaction> getTransactions(String userId);

    public List<Transaction> getTransactionsRecurrent(String userId);

    public List<TransactionReportMonth> getTransactionReportMonth(String userId);

    public List<TransactionReportMonth> getTransactionReport(String userId, String MoveId);

}

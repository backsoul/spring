package com.backsoul.transaction.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backsoul.MainApplication;
import com.backsoul.transaction.models.Transaction;
import com.backsoul.transaction.models.TransactionReportMonth;
import com.backsoul.transaction.services.TransactionServiceImpl;
import com.backsoul.utils.BodyData;

@RestController
@RequestMapping(MainApplication.BASE_API_URL + "/transaction")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping()
    public Transaction main(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        int amount = Integer.parseInt(bodyData.getPayloadValue("amount"));
        String description = bodyData.getPayloadValue("description");
        String categoryId = bodyData.getPayloadValue("categoryId");
        String moveId = bodyData.getPayloadValue("moveId");
        Boolean isRecurrent = Boolean.valueOf(bodyData.getPayloadValue("isRecurrent"));
        java.sql.Timestamp date = java.sql.Timestamp.valueOf(bodyData.getPayloadValue("date"));
        String month = (new SimpleDateFormat("MMMM")).format(date.getTime());
        return transactionServiceImpl.createTransaction(bodyData.getUserValue("Id"), amount, description, categoryId,
                moveId, date, isRecurrent, month);
    }

    @GetMapping()
    public List<Transaction> getWallet() {
        return transactionServiceImpl.getTransactions();
    }

    @GetMapping("/reportMonths")
    public List<TransactionReportMonth> getTransactionReportMonth(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        return transactionServiceImpl.getTransactionReportMonth(bodyData.getUserValue("Id"));
    }
}

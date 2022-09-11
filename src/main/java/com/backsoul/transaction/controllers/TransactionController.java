package com.backsoul.transaction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backsoul.MainApplication;
import com.backsoul.transaction.models.Transaction;
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
        return transactionServiceImpl.createTransaction(bodyData.getUserValue("Id"), amount, description, categoryId);
    }
}

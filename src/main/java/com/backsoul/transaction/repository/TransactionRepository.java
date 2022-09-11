package com.backsoul.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.transaction.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}

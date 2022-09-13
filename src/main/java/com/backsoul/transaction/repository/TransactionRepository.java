package com.backsoul.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.transaction.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    @Query("SELECT u FROM Transaction u JOIN u.moves r WHERE r.id LIKE %?1%")
    List<Transaction> findAllByMove(String moveId);

    List<Transaction> findAllBywalletId(String walletId);

    Iterable<Transaction> findTransactionByMoveId(String name);

}

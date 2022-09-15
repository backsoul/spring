package com.backsoul.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.move.model.Move;
import com.backsoul.transaction.models.Transaction;
import com.backsoul.wallet.model.Wallet;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findByWalletId(String walletId);

    List<Transaction> findByMoveIdAndWalletId(String moveId, String walletId);
}

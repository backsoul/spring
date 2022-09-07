package com.backsoul.finance.repositories;

import com.backsoul.finance.models.Wallet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, String> {
}

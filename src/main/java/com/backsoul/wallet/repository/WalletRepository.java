package com.backsoul.wallet.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.wallet.model.Wallet;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, String> {
    Optional<Wallet> findByuserId(String userId);
}

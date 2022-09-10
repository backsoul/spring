package com.backsoul.wallet.services;

import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.repositories.WalletRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Optional<Wallet> getWallet(String userId) {
        return walletRepository.findByuserId(userId);
    }

    @Override
    public int salaryAnual(int salary) {
        return salary * 12;
    }

    @Override
    public String createWallet(String userId) {
        try {
            Optional<Wallet> findWallet = walletRepository.findByuserId(userId);
            Boolean userIdHaveWallet = findWallet.isPresent();
            if (!userIdHaveWallet) {
                // Create object wallet
                Wallet wallet = new Wallet();
                wallet.setUserId(userId);
                // Save wallet object in repository
                Wallet _wallet = walletRepository.save(wallet);
                return _wallet.getId();
            } else {
                return findWallet.get().getId();
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Error al crear la wallet";
        }
    }

    @Override
    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).get();
    }
}

package com.backsoul.finance.services;

import com.backsoul.finance.models.Wallet;
import com.backsoul.finance.repositories.WalletRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    // @Autowired annotation is optional when using constructor injection
    WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> getWallets() {
        return (List<Wallet>) walletRepository.findAll();
    }

    @Override
    public int salaryAnual(int salary) {
        return salary * 12;
    }

    @Override
    public ResponseEntity<Wallet> createWallet() {
        try {

            Wallet _wallet = walletRepository.save(new Wallet());
            return new ResponseEntity<>(_wallet, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).get();
    }
}

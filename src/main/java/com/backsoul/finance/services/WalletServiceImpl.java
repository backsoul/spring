package com.backsoul.finance.services;

import com.backsoul.finance.models.WalletModel;
import com.backsoul.finance.repositories.WalletRepository;
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
    public List<WalletModel> getWallets() {
        return (List<WalletModel>) walletRepository.findAll();
    }

    @Override
    public int averageSalaryYear(int salary) {
        return salary;
    }
}

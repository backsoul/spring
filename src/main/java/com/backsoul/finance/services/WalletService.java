package com.backsoul.finance.services;

import java.util.List;
import java.util.UUID;

import com.backsoul.finance.models.WalletModel;

public interface WalletService {
    /**
     * @return
     */
    public List<WalletModel> getWallets();

    public int averageSalaryYear(int salary);
}

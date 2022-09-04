package com.backsoul.finance.services;

import java.util.List;

import com.backsoul.finance.models.WalletModel;

public interface WalletService {
    /**
     * @return
     */
    public List<WalletModel> getWallets();
}

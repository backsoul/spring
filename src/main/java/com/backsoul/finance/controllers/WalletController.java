package com.backsoul.finance.controllers;

import com.backsoul.finance.models.WalletModel;
import com.backsoul.finance.services.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletServiceImpl walletService;

    @GetMapping()
    public List<WalletModel> main() {
        return walletService.getWallets();
    }
}

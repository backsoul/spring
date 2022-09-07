package com.backsoul.finance.controllers;

import com.backsoul.finance.models.Wallet;
import com.backsoul.finance.services.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletServiceImpl walletService;

    @PostMapping()
    public ResponseEntity<Wallet> main() {
        return walletService.createWallet();
    }

    @GetMapping()
    public List<Wallet> getWallets() {
        return walletService.getWallets();
    }
}

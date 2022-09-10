package com.backsoul.wallet.controllers;

import com.backsoul.MainApplication;
import com.backsoul.forms.BodyData;
import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.services.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping(MainApplication.BASE_API_URL + "/wallet")
public class WalletController {

    @Autowired
    WalletServiceImpl walletService;

    @PostMapping("/create")
    public String main(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        return walletService.createWallet(bodyData.getUserValue("Id"));
    }

    @GetMapping()
    public Wallet getWallet(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        return walletService.getWallet(bodyData.getUserValue("Id")).get();
    }
}

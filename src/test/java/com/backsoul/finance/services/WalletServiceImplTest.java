package com.backsoul.finance.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;

import com.backsoul.finance.models.WalletModel;
import com.backsoul.finance.repositories.WalletRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class WalletServiceImplTest {

    @MockBean
    private WalletRepository walletRepository;

    @Autowired
    WalletServiceImpl walletService;

    private static final Logger LOG = LoggerFactory.getLogger(WalletServiceImplTest.class);

    /**
     * get alls wallets
     */
    @Test
    void testGetWallets() {
        WalletModel wallet = new WalletModel(4700000);
        List<WalletModel> wallets = new ArrayList<WalletModel>();
        wallets.add(wallet);
        when(walletRepository.findAll()).thenReturn(wallets);
        assertEquals(walletRepository.findAll(), walletService.getWallets());
    }

    @Test
    void testGetSalaryYear() {
        WalletModel wallet = new WalletModel(4700000);
        when(walletRepository.findById(wallet.getId())).thenReturn(Optional.of(wallet));
        var salaryRepository = walletService.averageSalaryYear(
                walletRepository.findById(wallet.getId()).get().getSalary());
        var salary = walletService.averageSalaryYear(wallet.getSalary());
        assertEquals(salaryRepository, salary);
    }

}

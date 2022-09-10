package com.backsoul.wallet.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backsoul.wallet.model.Wallet;
import com.backsoul.wallet.repositories.WalletRepository;
import com.backsoul.wallet.services.WalletServiceImpl;

@SpringBootTest
public class WalletServiceImplTest {

    @MockBean
    private WalletRepository walletRepository;

    @Autowired
    WalletServiceImpl walletService;

    /*
     *
     * List wallets.
     * 
     * @result get alls wallets
     */
    // @Test
    // void testGetWallets() {
    // Wallet wallet = new Wallet();
    // List<Wallet> wallets = new ArrayList<Wallet>();
    // wallets.add(wallet);
    // when(walletRepository.findAll()).thenReturn(wallets);
    // assertEquals(walletRepository.findAll(), walletService.getWallets());
    // }

    /*
     *
     * Get salary calculated salary in year.
     * 
     * @result salary in year calculated
     */
    // @Test
    // void testGetSalaryYear() {
    // Wallet wallet = new Wallet();

    // int salaryAmount = 4500000;

    // wallet.setSalary(salaryAmount);

    // when(walletRepository.findById(wallet.getId())).thenReturn(Optional.of(wallet));

    // var salaryRepository = walletService.salaryAnual(
    // walletRepository.findById(wallet.getId()).get().getSalary());

    // var salary = walletService.salaryAnual(salaryAmount);
    // assertEquals(salaryRepository, salary);
    // }

    /*
     * Create new wallet
     * 
     * @result assert the new wallet is created.
     */
    // @Test
    // void testCreateWallet() {
    // Wallet wallet = new Wallet();
    // when(walletRepository.save(wallet)).thenReturn(wallet);
    // walletRepository.save(wallet);
    // assertEquals(wallet, walletRepository.save(wallet));
    // }

}

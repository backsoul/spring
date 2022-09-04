package com.backsoul.finance.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backsoul.finance.models.WalletModel;
import com.backsoul.finance.repositories.WalletRepository;

@SpringBootTest
public class WalletServiceImplTest {

    @MockBean
    private WalletRepository walletRepository;

    @Autowired
    WalletServiceImpl walletService;

    /**
     * 
     */
    @Test
    void testGetWallets() {
        WalletModel wallet = new WalletModel();
        wallet.setId("id");
        wallet.setName("name");
        List<WalletModel> wallets = new ArrayList<WalletModel>();
        wallets.add(wallet);
        when(walletRepository.findAll()).thenReturn(wallets);
        assertEquals(walletRepository.findAll(), walletService.getWallets());
    }
}

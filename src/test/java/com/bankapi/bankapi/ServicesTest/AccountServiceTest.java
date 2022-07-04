package com.bankapi.bankapi.ServicesTest;

import com.bankapi.bankapi.Domain.Account;
import com.bankapi.bankapi.Domain.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bankapi.bankapi.Services.AccountService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


public class AccountServiceTest {


    private AccountService service;
    private Account accountFrom;
    private Account accountTo;


    @BeforeEach
    public void setup() {
        this.service = new AccountService();
        this.accountFrom = new Account(1000, UUID.randomUUID());
        this.accountTo = new Account(500, UUID.randomUUID());

        service.tempAccounts.add(accountFrom);
        service.tempAccounts.add(accountTo);
    }

    @Test
    void shouldTransfer() throws Exception{

        service.transfer(200,accountFrom.getAccountID().toString(),accountTo.getAccountID().toString());

        assertEquals(800,accountFrom.getAmmount());
        assertEquals(700,accountTo.getAmmount());

    }
    @Test
    void shouldDeposit() throws Exception{

        service.deposit(200,accountFrom.getAccountID().toString());
        assertEquals(1200,accountFrom.getAmmount());
    }
    @Test
    void shouldWithdraw() throws Exception{

        service.withDraw(200,accountFrom.getAccountID().toString());
        assertEquals(800,accountFrom.getAmmount());
    }

}

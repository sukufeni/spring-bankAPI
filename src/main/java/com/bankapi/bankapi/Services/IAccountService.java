package com.bankapi.bankapi.Services;

import java.util.List;
import com.bankapi.bankapi.Domain.Account;


public interface IAccountService {
    float getTotal(Account account)  throws Exception;
    Account getAccount(String accountID) throws Exception;
    void transfer(float ammount, String originAccount, String desAccount) throws Exception; 
    float withDraw(float ammount, String account)throws Exception;
    float deposit(float ammount, String accountID) throws Exception;
    List<Account> getAccounts();
}

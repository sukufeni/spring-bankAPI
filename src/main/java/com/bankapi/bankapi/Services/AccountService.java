package com.bankapi.bankapi.Services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bankapi.bankapi.Domain.Account;
import com.bankapi.bankapi.Domain.Client;

import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{

    public List<Account> tempAccounts;
    private final Client dumbClient;
    public AccountService() {
        this.dumbClient = new Client("joao", Date.valueOf(LocalDate.now()), 303195312, "address");
        UUID temp = UUID.fromString(this.dumbClient.getClientID());
        tempAccounts = new ArrayList<Account>();
        tempAccounts.addAll(List.of(new Account(200,temp),new Account(220,temp),new Account(230,temp)));
    }

    @Override
    public float withDraw(float ammount, String account) {
        try {
            Account handledAccount = this.getAccount(account);
            float finalAmmout = handledAccount.getAmmount()>ammount?handledAccount.getAmmount()-ammount:handledAccount.getAmmount();
            handledAccount.setAmmount(finalAmmout);
            return finalAmmout;
        }
        catch (Exception e) {
            return 0;
        }
    }

    @Override
    public float deposit(float ammount, String accountID) {
        try {
            Account handledAccount = this.getAccount(accountID);
            float finalAmmout = ammount>0?handledAccount.getAmmount()+ammount:handledAccount.getAmmount();
            handledAccount.setAmmount(finalAmmout);
            return finalAmmout;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public float getTotal(Account account) {
        return account.getAmmount();
    }

    @Override
    public Account getAccount(String accountID) throws Exception {
        Optional<Account> returnedAccount = tempAccounts.stream().filter(t->t.getAccountID().compareTo(UUID.fromString(accountID))==0).findFirst();
        if(returnedAccount.isEmpty())throw new Exception("Unable to find account from the given ID"); 

        return returnedAccount.get();
    }

    @Override
    public void transfer(float ammount, String originAccountID, String destAccountID) throws Exception {
            Account originAccount = this.getAccount(originAccountID);
            Account destAccount = this.getAccount(destAccountID);
            if(originAccount.getAmmount()>ammount){

                float finalAmmountOrigin = originAccount.getAmmount()-ammount;
                originAccount.setAmmount(finalAmmountOrigin);
                    
                float finalAmmoutDest = destAccount.getAmmount()+ammount;
                destAccount.setAmmount(finalAmmoutDest);
            }else throw new Exception("Low account balance");
    }

    @Override
    public List<Account> getAccounts() {
        return tempAccounts;
    }
    
}

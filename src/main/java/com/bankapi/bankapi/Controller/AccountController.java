package com.bankapi.bankapi.Controller;

import java.util.List;

import com.bankapi.bankapi.Domain.Account;
import com.bankapi.bankapi.Services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/accounts/")
public class AccountController {
    
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping(path = "/deposit")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<Float> depositAmmount(@RequestParam("accountID") final String account, @RequestParam("ammount") final float ammount){
        return ResponseEntity.ok(this.accountService.deposit(ammount, account));
    }
    @PutMapping(path = "/withDraw")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<Float> withDraw(@RequestParam("accountID")final String account, @RequestParam("ammount") final float ammount){
        return ResponseEntity.ok(this.accountService.withDraw(ammount, account));
    }

    @PutMapping(path = "/transfer")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<String> transfer(String originAccountID, String destAccountID, float ammount){
        try {
            this.accountService.transfer(ammount, originAccountID, destAccountID);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/getAll")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(this.accountService.getAccounts());
    }

    @GetMapping(path = "/getAccount")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<Account> getAccount(@RequestParam("accountID") final String accountID) throws Exception{
        return ResponseEntity.ok(this.accountService.getAccount(accountID));
    }
}

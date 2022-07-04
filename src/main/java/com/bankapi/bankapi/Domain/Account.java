package com.bankapi.bankapi.Domain;

import java.util.UUID;

import org.springframework.stereotype.Component;



public class Account {

    private final UUID accountID;
    private final UUID ownerID;
    private float ammount;
    
    public Account(UUID owner) {
        this.ammount = 0;
        this.ownerID = owner;
        this.accountID = UUID.randomUUID();
    }

    public Account(float ammount, UUID owner) {
        this.accountID = UUID.randomUUID();
        this.ammount = ammount;
        this.ownerID = owner;
    }
    
    public float getAmmount() {
        return ammount;
    }
    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }
    public UUID getAccountID(){
        return this.accountID;
    }
}

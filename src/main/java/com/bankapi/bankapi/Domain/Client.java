package com.bankapi.bankapi.Domain;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class Client extends Person{
    private UUID clientID;
    private List<Account> accounts;    

    public Client(String name, Date birthDate, long vatNumber, String address) {
        super(name, birthDate, vatNumber, address);
        this.clientID=UUID.randomUUID();
        this.accounts = List.of(new Account(UUID.fromString(this.getClientID())));
    }

    public String getClientID() {
        return this.clientID.toString();
    }
    public List<Account> getAccounts(){
        return this.accounts;
    }
}

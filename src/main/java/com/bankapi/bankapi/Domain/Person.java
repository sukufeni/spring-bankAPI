package com.bankapi.bankapi.Domain;

import java.sql.Date;

public class Person {
    private String name;
    private Date birthDate;
    private long vatNumber;
    private String address;
    

    public Person(String name, Date birthDate, long vatNumber, String address) {
        this.name= name;
        this.birthDate = birthDate;
        this.vatNumber = vatNumber;
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public long getVatNumber() {
        return this.vatNumber;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getName() {
        return this.name;
    }
    
}

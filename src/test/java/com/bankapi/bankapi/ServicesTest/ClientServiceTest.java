package com.bankapi.bankapi.ServicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.bankapi.bankapi.Domain.Client;
import com.bankapi.bankapi.Services.ClientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClientServiceTest {

    private ClientService service;

    @BeforeEach
    void setup(){
        this.service = new ClientService();
    }


    @Test
    
    void shouldReturnClients(){

        List<Client> actual = service.fetchClients();
        
        assertEquals(0,actual.size());
    }

    @Test
    void shouldAddClient() throws Exception{

        Client dumbClient = new Client("Bruno", Date.valueOf(LocalDate.now()), 303195312, "address");
        service.addClient(dumbClient);
        List<Client> actual = service.fetchClients();
        assertEquals(1,actual.size());
    }

}

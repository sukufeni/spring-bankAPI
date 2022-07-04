package com.bankapi.bankapi.Services;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bankapi.bankapi.Domain.Client;

import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{

    private List<Client> tempClients = new ArrayList<Client>();

    @Override
    public List<Client> fetchClients() {
        return this.tempClients;
    }

    @Override
    public Client fetchClient(String clientID) throws Exception {
        Optional<Client> retClient = this.tempClients.stream().filter(o->o.getClientID().equals(clientID)).findFirst();
        try {
            return retClient.get();
        } catch (Exception e) {
            throw new Exception("Unable to fetch Client");
        } 
    }

    @Override
    public void addClient(Client client) throws Exception {
        try {
            this.tempClients.add(client);
        } catch (Exception e) {
            throw new Exception("Unable to save client");
        }
    }
}

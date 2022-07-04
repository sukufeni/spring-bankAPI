package com.bankapi.bankapi.Services;

import java.util.List;
import java.util.UUID;

import com.bankapi.bankapi.Domain.Client;

public interface IClientService {
    List<Client> fetchClients();
    Client fetchClient(String clientID) throws Exception;
    void addClient(Client client) throws Exception;
    // Client updatClient(Client client);
}

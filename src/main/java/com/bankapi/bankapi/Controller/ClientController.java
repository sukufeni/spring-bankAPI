package com.bankapi.bankapi.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.bankapi.bankapi.Domain.Client;
import com.bankapi.bankapi.Services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {
    
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/getClient")
    ResponseEntity<Client> getClient( @RequestParam("clientID") final String clientID) throws Exception {

        try{
            return ResponseEntity.ok(clientService.fetchClient(clientID));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/getAll")
    ResponseEntity<List<Client>> getClients(){
        List<Client> retClients = clientService.fetchClients();
        retClients.forEach(o-> System.out.println(o.getName()));
        return ResponseEntity.ok(clientService.fetchClients());
    }

    @PostMapping(path = "/add")
    ResponseEntity<Void> addClient(@RequestBody final Client client){
        try {
            this.clientService.addClient(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @PutMapping
    void UpdateClient(Client client){
        
    }

    @DeleteMapping
    //client and the dependents accounts
    void DeleteClient(Client client){
        
    }
}

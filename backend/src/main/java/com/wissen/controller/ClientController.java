package com.wissen.controller;

import com.wissen.entity.Client;
import com.wissen.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * API to save Client if it doesn't exist in database
     * @param clients
     * @return saved Client response list
     */
    @PostMapping
    public ResponseEntity<List<Client>> saveClient(@RequestBody @NotEmpty(message = "Client list cannot be empty. Provide a valid Client list") final List<@Valid Client> clients) {
        log.debug("Saving clients : {}", clients);
        List<Client> savedClients = this.clientService.saveClients(clients);
        log.debug("Saved clients response {}",savedClients);
        return ResponseEntity.status(HttpStatus.OK).body(savedClients);
    }

    /**
     * API to search Client Name based on the input string feed
     * @param clientName
     * @return list of the client matching the search string
     */
    @GetMapping("/search")
    public ResponseEntity<List<Client>> searchClients(@RequestParam final String clientName) {
        log.debug("Fetching the clients based on the input text {}", clientName);
        List<Client> clientsList = this.clientService.searchClients(clientName);
        log.debug("List of clients matching the search String {}", clientsList);
        return ResponseEntity.status(HttpStatus.OK).body(clientsList);
    }

    /**
     * API to fech Client details based on ID
     * @param clientId
     * @return Client Details
     */
    @GetMapping
    public ResponseEntity<Client> getClientsById(@RequestParam @NotNull(message = "Client id is null") final int clientId) {
        log.debug("Fetching the clients based for Client_ID {}", clientId);
        Client client = this.clientService.getClientById(clientId);
        log.debug("Client Response for the ID {} is {}", clientId, client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    /**
     * @author Vishal Tomar
     * @description Method to fetch all clients.
     * @return List of clients.
     */
    @GetMapping("/allClients")
    public ResponseEntity<List<Client>> getAllClients() {
        log.debug("Fetching all clients");
        List<Client> clientsList = this.clientService.getAllClients();
        log.debug("All clients Response is {}", clientsList);
        return ResponseEntity.status(HttpStatus.OK).body(clientsList);
    }
}

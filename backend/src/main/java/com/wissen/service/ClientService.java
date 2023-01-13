package com.wissen.service;

import com.wissen.entity.Client;
import com.wissen.exception.DataAlreadyExistException;

import java.util.List;

public interface ClientService {

    /**
     * Method to save clients details
     *
     * @param clients
     * @return savedClients
     */
    public List<Client> saveClients(final List<Client> clients) throws DataAlreadyExistException;

    /**
     * Method to search clients
     *
     * @param searchString
     * @return clients
     */
    public List<Client> searchClients(final String searchString);

    /**
     * Method to search client by id.
     *
     * @param clientId
     * @return client
     */
    public Client getClientById(final int clientId);

    /**
     * @author Vishal Tomar
     * @description Method to fetch all clients.
     * @return List of clients.
     */
    public List<Client> getAllClients();
}

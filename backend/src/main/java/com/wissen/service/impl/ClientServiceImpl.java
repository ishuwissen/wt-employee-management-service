package com.wissen.service.impl;

import com.wissen.entity.Client;
import com.wissen.exception.DataAlreadyExistException;
import com.wissen.repository.ClientRepository;
import com.wissen.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation class for client related things.
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> saveClients(final List<Client> clients) throws DataAlreadyExistException {

        if(validateClientSaveRequest(clients)) {
            return this.clientRepository.saveAll(clients);
        }
        return null;
    }

    /**
     * If combination of client name and client location exists,
     * then throw an error and if it doesn't then insert/update as per client id.
     * @throws
     * @param clients
     * @return validate
     * @author Anushka Saxena
     */
    private boolean validateClientSaveRequest(List<Client> clients) throws DataAlreadyExistException{
        clients.stream().forEach(client -> {
            if(clientRepository.isClientExists(client.getClientName(), client.getClientLocation())) {
                log.error("The Client details are already present : " + client.toString());
                throw new DataAlreadyExistException("Details already present : " + client.toString());
            }
        });

        return Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> searchClients(String searchString) {
        List<Client> clients = new ArrayList<>();
        clients.addAll(this.clientRepository.getClientByPattern(searchString));
        return clients;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client getClientById(int clientId) {
        Optional<Client> result =  this.clientRepository.findById(clientId);
        if(Objects.nonNull(result))
            return result.get();
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

}

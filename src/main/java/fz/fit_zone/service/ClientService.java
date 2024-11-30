package fz.fit_zone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fz.fit_zone.model.Client;
import fz.fit_zone.repository.ClientRepository;



@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> listClient() {
        List<Client> clients = clientRepository.findAll();
        return clients;
        
    }

    @Override
    public Client searchClientById(Integer idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        return client;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void removeClient(Client client) {
        clientRepository.delete(client);
    }

}

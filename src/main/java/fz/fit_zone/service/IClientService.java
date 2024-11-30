package fz.fit_zone.service;

import java.util.List;

import fz.fit_zone.model.Client;

public interface IClientService {
    public List<Client> listClient();

    public Client searchClientById(Integer idClient);

    public void saveClient(Client client);

    public void removeClient(Client client);


}

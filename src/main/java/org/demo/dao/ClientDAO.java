package org.demo.dao;

import org.demo.entities.Client;
import javax.persistence.EntityManager;
import java.util.List;

public class ClientDAO {
    private EntityManager manager;

    public ClientDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Client client) {
        this.manager.persist(client);
    }

    public Client findById(Long id) {
        return manager.find(Client.class, id);
    }

    public List<Client> findAll() {
        return manager.createQuery("select p from Client p", Client.class).getResultList();
    }
}

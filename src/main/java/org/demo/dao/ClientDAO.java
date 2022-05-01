package org.demo.dao;

import org.demo.entities.Client;
import javax.persistence.EntityManager;

public class ClientDAO {
    private EntityManager manager;

    public ClientDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Client client){
        this.manager.persist(client);
    }
}

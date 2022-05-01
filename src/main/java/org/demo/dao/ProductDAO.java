package org.demo.dao;

import org.demo.entities.Product;
import javax.persistence.EntityManager;

public class ProductDAO {
    private EntityManager manager;

    public ProductDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Product product){
        this.manager.persist(product);
    }

    public Product update(Product product){
        return manager.merge(product);
    }

    public void delete(Product product){
        product = manager.merge(product);
        manager.remove(product);
    }
}

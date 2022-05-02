package org.demo.dao;

import org.demo.entities.Order;
import javax.persistence.EntityManager;
import java.util.List;

public class OrderDAO {
    private EntityManager manager;

    public OrderDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Order order) {
        this.manager.persist(order);
    }

    public Order update(Order order) {
        return manager.merge(order);
    }

    public void delete(Order order) {
        order = manager.merge(order);
        manager.remove(order);
    }

    public Order findById(Long id) {
        return manager.find(Order.class, id);
    }

    public List<Order> findAll(){
        return manager.createQuery("select p from Order p", Order.class).getResultList();
    }
}

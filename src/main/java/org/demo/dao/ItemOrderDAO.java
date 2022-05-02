package org.demo.dao;

import org.demo.entities.OrderItem;
import javax.persistence.EntityManager;
import java.util.List;

public class ItemOrderDAO {
    private EntityManager manager;

    public ItemOrderDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(OrderItem orderItem) {
        this.manager.persist(orderItem);
    }

    public OrderItem update(OrderItem orderItem) {
        return manager.merge(orderItem);
    }

    public void delete(OrderItem orderItem) {
        orderItem = manager.merge(orderItem);
        manager.remove(orderItem);
    }

    public OrderItem findById(Long id) {
        return manager.find(OrderItem.class, id);
    }

    public List<OrderItem> findAll(){
        return manager.createQuery("select p from OrderItem p", OrderItem.class).getResultList();
    }
}

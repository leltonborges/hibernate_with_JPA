package org.demo.dao;

import org.demo.entities.PurchaseOrder;
import javax.persistence.EntityManager;

public class PurchaseOrderDAO {
    private EntityManager manager;

    public PurchaseOrderDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(PurchaseOrder purchaseOrder){
        this.manager.persist(purchaseOrder);
    }

    public PurchaseOrder update(PurchaseOrder purchaseOrder){
        return manager.merge(purchaseOrder);
    }

    public void delete(PurchaseOrder purchaseOrder){
        purchaseOrder = manager.merge(purchaseOrder);
        manager.remove(purchaseOrder);
    }
}

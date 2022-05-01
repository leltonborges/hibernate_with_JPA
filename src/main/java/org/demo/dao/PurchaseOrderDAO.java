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
}

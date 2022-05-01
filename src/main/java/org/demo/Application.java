package org.demo;

import org.demo.dao.CategoryDAO;
import org.demo.dao.ClientDAO;
import org.demo.dao.ProductDAO;
import org.demo.dao.PurchaseOrderDAO;
import org.demo.entities.Category;
import org.demo.entities.Client;
import org.demo.entities.Product;
import org.demo.entities.PurchaseOrder;
import org.demo.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Category celulares = new Category(null, "Celulares");
        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399), celulares, null, null);
        Client  lia = new Client(null, "Lia", "lia@lia.com");
        PurchaseOrder order1 = new PurchaseOrder();

        EntityManager manager = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);
        ClientDAO clientDAO = new ClientDAO(manager);
        PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO(manager);

        manager.getTransaction().begin();
        categoryDAO.save(celulares);
        manager.flush();
        productDAO.save(p1);
        clientDAO.save(lia);
        manager.flush();
        order1 = new PurchaseOrder(p1, lia);
        purchaseOrderDAO.save(order1);

        manager.flush();

        manager.getTransaction().commit();
    }
}

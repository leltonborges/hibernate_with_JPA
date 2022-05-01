package org.demo;

import org.demo.dao.ProductDAO;
import org.demo.entities.Category;
import org.demo.entities.Product;
import org.demo.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399), Category.CELULARES, null, null);
        EntityManager manager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(manager);
        manager.getTransaction().begin();
        productDAO.save(p1);
        manager.getTransaction().commit();
    }
}

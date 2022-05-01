package org.demo;

import org.demo.dao.CategoryDAO;
import org.demo.dao.ProductDAO;
import org.demo.entities.Category;
import org.demo.entities.Product;
import org.demo.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Category celulares = new Category(null, "Celulares");

        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399), celulares, null, null);
        EntityManager manager = JPAUtil.getEntityManager();

        CategoryDAO categoryDAO = new CategoryDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);

        manager.getTransaction().begin();
        categoryDAO.save(celulares);
        productDAO.save(p1);
        manager.getTransaction().commit();
    }
}

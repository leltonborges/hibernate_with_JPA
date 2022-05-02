package org.demo;

import org.demo.dao.*;
import org.demo.entities.*;
import org.demo.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        saveEntities();
        findEntities();



    }

    private static void findEntities() {
        EntityManager manager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(manager);

        System.out.println(productDAO.findByName("Phone"));
        System.out.println(productDAO.findByCategoryName("Celulares"));
        System.out.println(productDAO.findByProductPrice(1L));
    }

    private static void saveEntities() {
        Category celulares = new Category(null, "Celulares");
        Category carros = new Category(null, "Carros");
        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399), celulares, null, null);
        Client  lia = new Client(null, "Lia", "lia@lia.com", "1825");
        Order order1 = new Order(null, lia);
        OrderItem orderItem = new OrderItem(p1, order1, 32);
        order1.addItem(orderItem);

        EntityManager manager = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);
        ClientDAO clientDAO = new ClientDAO(manager);
        ItemOrderDAO itemOrderDAO = new ItemOrderDAO(manager);
        OrderDAO orderDAO = new OrderDAO(manager);

        manager.getTransaction().begin();
        categoryDAO.save(celulares);
        categoryDAO.save(carros);
        manager.flush();
        productDAO.save(p1);
        clientDAO.save(lia);
        manager.flush();
        orderDAO.save(order1);
        itemOrderDAO.save(orderItem);
        manager.flush();
        manager.clear();
        carros = categoryDAO.update(carros);
        orderItem = itemOrderDAO.update(orderItem);
        itemOrderDAO.save(orderItem);

        manager.remove(carros);
        manager.getTransaction().commit();
    }
}

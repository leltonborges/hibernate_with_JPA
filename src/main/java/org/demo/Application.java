package org.demo;

import org.demo.dao.*;
import org.demo.entities.*;
import org.demo.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        saveEntities();
        findEntities();
        selectNew();
    }

    private static void selectNew() {
        EntityManager manager = JPAUtil.getEntityManager();
        OrderDAO orderDAO = new OrderDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);

        orderDAO.getSalesReport().forEach(System.out::println);
        Order order = manager.createQuery("SELECT o FROM Order o join fetch o.client where o.id = :id", Order.class)
                .setParameter("id", 1L)
                .getSingleResult();
        order.getClient().getName();

        productDAO.findByParameteresWithCriteria("Phone", null, new Date());
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
        Category informatica = new Category(null, "Informatica");
        Category catDelete = new Category(null, "delete");
        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399), celulares);
        Product p2 = new Product(null, "HD Externo", "HD Externo de 500 GB", BigDecimal.valueOf(399.99), informatica);
        Client  lia = new Client(null, "Lia", "lia@lia.com", new PersonalData("21221", 156));
        Order order1 = new Order(null, lia);
        OrderItem orderItem1 = new OrderItem(p1, order1, 10);
        OrderItem orderItem2 = new OrderItem(p2, order1, 5);
        order1.addItem(orderItem1);
        order1.addItem(orderItem2);
        order1.calcTotalValue();

        EntityManager manager = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);
        ClientDAO clientDAO = new ClientDAO(manager);
        ItemOrderDAO itemOrderDAO = new ItemOrderDAO(manager);
        OrderDAO orderDAO = new OrderDAO(manager);

        manager.getTransaction().begin();
        categoryDAO.save(celulares);
        categoryDAO.save(informatica);
        categoryDAO.save(catDelete);
        manager.flush();
        productDAO.save(p1);
        clientDAO.save(lia);
        manager.flush();
        orderDAO.save(order1);
        itemOrderDAO.save(orderItem1);
        itemOrderDAO.save(orderItem2);
        manager.flush();
        manager.clear();
        catDelete = categoryDAO.update(catDelete);
        orderItem1 = itemOrderDAO.update(orderItem1);
        itemOrderDAO.save(orderItem1);
        categoryDAO.delete(catDelete);
        manager.getTransaction().commit();

        System.out.println(productDAO.findByCategoryName("Celulares"));
    }
}

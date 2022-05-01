package org.demo;

import org.demo.entities.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        Product p1 = new Product(null, "Phone", "Xioami Redmi", BigDecimal.valueOf(2399));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager manager = null;
        try {
            manager = factory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(p1);
            manager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            manager.close();
        }

    }
}

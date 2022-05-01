package org.demo.dao;

import org.demo.entities.Product;
import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {
    private EntityManager manager;

    public ProductDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Product product) {
        this.manager.persist(product);
    }

    public Product update(Product product) {
        return manager.merge(product);
    }

    public void delete(Product product) {
        product = manager.merge(product);
        manager.remove(product);
    }

    public Product findById(Long id) {
        return manager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return manager.createQuery("select p from Product p", Product.class).getResultList();
    }

    public List<Product> findByName(String name){
        return manager.createQuery("select p from Product p where p.name = :pName", Product.class)
//        return manager.createQuery("select p from Product p where p.name = ?1", Product.class)
                .setParameter("pName", name)
                .getResultList();
    }

    public List<Product> findByCategoryName(String name){
        return manager.createQuery("select p from Product p where p.category.nome = :cName", Product.class)
                .setParameter("cName", name)
                .getResultList();
    }


}

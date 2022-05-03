package org.demo.dao;

import org.demo.entities.Product;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Date;
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
//        return manager.createQuery("select p from Product p where p.category.nome = :cName", Product.class)
        return manager.createNamedQuery("Product.productByCategory", Product.class)
                .setParameter("cName", name)
                .getResultList();
    }

    public BigDecimal findByProductPrice(Long id){
        return manager.createQuery("select p.price from Product p where p.id = :pkProduct", BigDecimal.class)
                .setParameter("pkProduct", id)
                .getSingleResult();

    }

    public List<Product> findByParameteres(String name, BigDecimal price, Date createdAt){
        String sql = "SELECT p FROM Product p WHERE 1=1";
        if(!name.isBlank()){
            sql.concat("AND p.name = :name");
        }
        if(price != null)
            sql.concat("AND p.price = :price");
        if(createdAt != null)
            sql.concat("AND p.createdAt = :createdAt");


        TypedQuery<Product> query = this.manager.createQuery(sql, Product.class);
        if(!name.isBlank()){
            query.setParameter("name", name);
        }
        if(price != null)
            query.setParameter("price", price);
        if(createdAt != null)
            query.setParameter("createdAt", createdAt);

        return query.getResultList();
    }

    public List<Product> findByParameteresWithCriteria(String name, BigDecimal price, Date createdAt){
        CriteriaBuilder builder = this.manager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        Predicate filters = builder.and();
        if(name != null && !name.trim().isEmpty())
            filters = builder.and(filters, builder.equal(from.get("name"), name));
        if(price != null)
            filters = builder.and(filters, builder.equal(from.get("price"), price));
        if(createdAt != null)
            filters = builder.and(filters, builder.equal(from.get("createdAt"), createdAt));

        query.where(filters);

        return this.manager.createQuery(query).getResultList();
    }
}

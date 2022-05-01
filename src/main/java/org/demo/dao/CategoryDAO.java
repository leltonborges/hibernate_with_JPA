package org.demo.dao;

import org.demo.entities.Category;
import javax.persistence.EntityManager;

public class CategoryDAO {
    private EntityManager manager;

    public CategoryDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Category category){
        this.manager.persist(category);
    }

    public Category update(Category category){
        return manager.merge(category);
    }

    public void delete(Category category){
        category = manager.merge(category);
        manager.remove(category);
    }
}

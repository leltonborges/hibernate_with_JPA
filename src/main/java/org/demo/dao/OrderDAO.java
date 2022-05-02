package org.demo.dao;

import org.demo.entities.Order;
import org.demo.vo.SoldReportVO;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {
    private EntityManager manager;

    public OrderDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Order order) {
        this.manager.persist(order);
    }

    public Order update(Order order) {
        return manager.merge(order);
    }

    public void delete(Order order) {
        order = manager.merge(order);
        manager.remove(order);
    }

    public Order findById(Long id) {
        return manager.find(Order.class, id);
    }

    public List<Order> findAll(){
        return manager.createQuery("select p from Order p", Order.class).getResultList();
    }

    public BigDecimal totalValueSold(){
        return this.manager.createQuery("select SUM(o.totalValue) from Order o", BigDecimal.class)
                .getSingleResult();

    }

    public List<SoldReportVO> getSalesReport(){
        return this.manager.createQuery("SELECT new org.demo.vo.SoldReportVO(p.name, SUM(item.quantity), MAX(p.createdAt)) FROM Order o join o.items item join item.product p GROUP BY p.name order by item.quantity desc", SoldReportVO.class)
                .getResultList();
    }
}

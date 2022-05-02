package org.demo.entities;

import lombok.*;
import org.demo.entities.pk.OrderItemPK;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_item_order")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK orderPK;

    @MapsId("product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @MapsId("order")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private Integer quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice = BigDecimal.ONE;

    public OrderItem() {
        this.orderPK = new OrderItemPK();
    }

    public OrderItem(Product product, Order order, Integer quantity) {
        this();
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public BigDecimal getTotalItem(){
        return this.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }
}

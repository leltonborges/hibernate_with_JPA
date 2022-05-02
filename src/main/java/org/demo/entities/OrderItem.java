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
    @ManyToOne
    private Product product;

    @MapsId("order")
    @ManyToOne
    private Order order;

    private Integer quantidade;
    private BigDecimal unitPrice;

    public OrderItem() {
        this.orderPK = new OrderItemPK();
    }

    public OrderItem(Product product, Order order, Integer quantidade) {
        this();
        this.product = product;
        this.order = order;
        this.quantidade = quantidade;
        this.unitPrice = product.getPrice();
    }
}

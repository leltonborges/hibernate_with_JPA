package org.demo.entities;

import lombok.*;
import org.demo.entities.pk.PurchaseOrderPK;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"orderPK","createdAt", "updatedAt"})
@Table(name = "tb_purchase_order")
public class PurchaseOrder {

    @EmbeddedId
    private PurchaseOrderPK orderPK;

    @MapsId("product")
    @ManyToOne
    private Product product;

    @MapsId("client")
    @ManyToOne
    private Client client;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public PurchaseOrder() {
        this.orderPK = new PurchaseOrderPK();
    }

    public PurchaseOrder(Product product, Client client) {
        this();
        this.product = product;
        this.client = client;
    }
}

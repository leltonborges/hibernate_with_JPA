package org.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.entities.pk.PurchaseOrderPK;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}

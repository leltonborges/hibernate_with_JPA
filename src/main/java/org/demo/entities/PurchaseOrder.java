package org.demo.entities;

import lombok.*;
import org.demo.entities.pk.PurchaseOrderPK;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_purchase_order")
public class PurchaseOrder {

    @EmbeddedId
    private PurchaseOrderPK orderPK;

    @NonNull
    @MapsId("product")
    @ManyToOne
    private Product product;

    @NonNull
    @MapsId("client")
    @ManyToOne
    private Client client;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

}

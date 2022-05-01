package org.demo.entities.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class PurchaseOrderPK implements Serializable {
    private static final long serialVersionUID = 439447912036923852L;

    private Long product;
    private Long client;
}

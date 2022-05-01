package org.demo.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"createdAt", "updatedAt"})
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = -3123991946224455757L;

    @Id
    @GeneratedValue(generator = "sequence_table_product")
    @SequenceGenerator(name = "sequence_table_product", sequenceName = "SEQUENCE_TB_PRODUCT", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne
    private Category category;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}

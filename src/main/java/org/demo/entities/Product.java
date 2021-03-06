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
@NoArgsConstructor
@Entity
@ToString
@Table(name = "tb_product")
@NamedQuery(name = "Product.productByCategory",
        query = "select p from Product p where p.category.nome = :cName")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {
    private static final long serialVersionUID = -3123991946224455757L;

    @Id
    @GeneratedValue(generator = "sequence_table_product")
    @SequenceGenerator(name = "sequence_table_product", sequenceName = "SEQUENCE_TB_PRODUCT", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Product(Long id, String name, String description, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}

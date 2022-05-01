package org.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}

package org.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(generator = "sequence_table_category")
    @SequenceGenerator(name = "sequence_table_category", sequenceName = "SEQUENCE_TB_CATEGORY", initialValue = 1, allocationSize = 1)
    private Long id;
    private String nome;
}

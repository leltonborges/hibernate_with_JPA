package org.demo.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_category")
public class Category {
    
    @EmbeddedId
    private CategoryID id;

    private String nome;
}

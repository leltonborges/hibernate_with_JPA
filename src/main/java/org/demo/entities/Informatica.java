package org.demo.entities;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_informatica")
public class Informatica extends Product{
    private String marca;
    private Integer tagNumber;
}

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
@Table(name = "tb_book")
public class Book extends Product{
    private String author;
    private Integer numberPage;
}

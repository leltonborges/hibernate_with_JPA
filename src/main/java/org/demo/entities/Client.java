package org.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 9000858968798358337L;

    @Id
    @GeneratedValue(generator = "sequence_table_client")
    @SequenceGenerator(name = "sequence_table_client", sequenceName = "SEQUENCE_TB_CLIENT", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
}

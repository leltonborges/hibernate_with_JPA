package org.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryID implements Serializable {
    private static final long serialVersionUID = -3998788119679408519L;

    private Long id;

    private Long type;
}

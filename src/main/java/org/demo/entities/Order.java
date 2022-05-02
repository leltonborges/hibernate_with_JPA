package org.demo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(generator = "sequence_table_order")
    @SequenceGenerator(name = "sequence_table_order", sequenceName = "SEQUENCE_TB_ORDER", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @Column(name = "total_value")
    private BigDecimal totalValue = BigDecimal.ZERO;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(Long id, Client client) {
        this();
        this.id = id;
        this.client = client;
    }

    public void addItem(OrderItem item){
        item.setOrder(this);
        this.items.add(item);
        this.totalValue = this.totalValue.add(item.getTotalItem());
    }

    public void calcTotalValue(){
        this.totalValue = this.items.stream()
                .map(i -> i.getUnitPrice().multiply(new BigDecimal(i.getQuantity())))
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}

package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;
    private int numberOfProducts;
    private Double price;
    @ManyToOne()
    private Order order;
}

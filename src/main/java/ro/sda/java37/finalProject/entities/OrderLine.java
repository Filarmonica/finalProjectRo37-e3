package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int numberOfProducts;
    @ManyToOne
    @JoinColumn(name = "price_id")
    private Product price;

}

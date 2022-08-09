package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private double price;
    private ProductType productType;
    private Brand brand;
}

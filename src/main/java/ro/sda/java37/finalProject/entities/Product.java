package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private Category category;
    private double price;
    private ProductType productType;
    private Brand brand;




}

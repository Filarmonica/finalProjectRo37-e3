package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private Category category;
    private double price;
    private ProductType productType;
    private Brand brand;




}

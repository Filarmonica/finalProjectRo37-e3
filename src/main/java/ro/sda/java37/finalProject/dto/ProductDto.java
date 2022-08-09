package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Brand;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.entities.ProductType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private Category category;
    private double price;
    private ProductType productType;
    private Brand brand;
}

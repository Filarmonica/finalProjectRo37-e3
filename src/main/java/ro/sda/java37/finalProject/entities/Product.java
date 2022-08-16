package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ro.sda.java37.finalProject.enums.Brand;
import ro.sda.java37.finalProject.enums.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue
  private Long id;
  @NotEmpty
  @Length(min = 3, message = "Product's name should have a length of at least three characters.")
  private String name;
  @NotEmpty
  @Length(min = 10, message = "Product's description should have a length of at least ten characters.")
  private String description;
  @NotEmpty
  private String thumbnail;
  @ManyToOne
  private Category category;
  private double price;
  private ProductType productType;
  private Brand brand;
}

package ro.sda.java37.finalProject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ro.sda.java37.finalProject.enums.Brand;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.enums.ProductType;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductDto {
  private Long id;
  @NotEmpty
  @Length(min = 3, message = "Product's name should have a length of at least three characters.")
  private String name;
  @NotEmpty
  @Length(min = 10, message = "Product's description should have a length of at least ten characters.")
  private String description;
  @NotEmpty
  private String thumbnail;
  private Category category;
  private double price;
  private ProductType productType;
  private Brand brand;
}

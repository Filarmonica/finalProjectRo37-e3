package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Category;

import java.util.List;

@Data
public class CategoryDto {
  private Long id;
  private Category parentCategory;
  private List<Category> subCategories;
  String name;
  String description;
}

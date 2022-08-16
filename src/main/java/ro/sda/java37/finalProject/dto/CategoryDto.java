package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Category;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CategoryDto {
  private Long id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String description;
  private Category parentCategory;
  private List<Category> subCategories;
}

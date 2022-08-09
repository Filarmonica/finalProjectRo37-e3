package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Category;

@Data
public class CategoryDto {
    private Long id;
    private Category parentCategory;
}

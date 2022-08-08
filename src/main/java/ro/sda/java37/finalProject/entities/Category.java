package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private Category parentCategory;
    private ProductType subcategories;
    public Category() {

    }
    public Category(Long id, Category parentCategory, ProductType subcategories) {
        this.id = id;
        this.parentCategory = parentCategory;
        this.subcategories = subcategories;
    }
}




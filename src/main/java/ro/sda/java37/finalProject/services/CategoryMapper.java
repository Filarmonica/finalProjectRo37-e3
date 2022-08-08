package ro.sda.java37.finalProject.services;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.repository.CategoryRepository;

@Service
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    private final CategoryRepository categoryRepository;

    public CategoryMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto convertToDto(Category entity) {
        CategoryDto categoryForm = new CategoryDto();
        categoryForm.setId(entity.getId());
        categoryForm.setParentCategory(entity.getParentCategory());
        categoryForm.setSubcategories(entity.getSubcategories());
        return categoryForm;
    }

    @Override
    public Category convertToEntity(CategoryDto dto) {
        Category category;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            category = categoryRepository.findById(dto.getId()).orElse(new Category());
        } else { // altfel se va creea alta
            category = new Category();
        }
        category.setId(dto.getId());
        category.setParentCategory(dto.getParentCategory());
        category.setSubcategories(dto.getSubcategories());

        return category;
    }
}

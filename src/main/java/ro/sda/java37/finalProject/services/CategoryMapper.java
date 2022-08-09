package ro.sda.java37.finalProject.services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.repository.CategoryRepository;

@AllArgsConstructor
@Service
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto convertToDto(Category entity) {
        CategoryDto categoryForm = new CategoryDto();
        categoryForm.setId(entity.getId());
        categoryForm.setParentCategory(entity.getParentCategory());
        categoryForm.setSubCategories(entity.getSubCategories());
        categoryForm.setName(entity.getName());
        categoryForm.setDescription(entity.getDescription());
        return categoryForm;
    }

    @Override
    public Category convertToEntity(CategoryDto dto) {
        Category category;
        if (dto.getId() != null) {
            category = categoryRepository.findById(dto.getId()).orElse(new Category());
        } else {
            category = new Category();
        }
        category.setId(dto.getId());
        category.setParentCategory(dto.getParentCategory());
        category.setSubCategories(dto.getSubCategories());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }
}

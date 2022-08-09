package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.convertToDto(category)).collect(Collectors.toList());
    }

    public CategoryDto createCategory(CategoryDto form) {
        Category category = categoryMapper.convertToEntity(form);
        categoryRepository.save(category);
        return form;
    }

    public CategoryDto findById(long id) {
        Category entityCategory = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        return categoryMapper.convertToDto(entityCategory);
    }

    public void deleteById(long id) {
        categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        categoryRepository.deleteById(id);
    }
}

package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.entities.Category;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void createCategory(CategoryDto form) {
        Category category = categoryMapper.convertToEntity(form);
        categoryRepository.save(category);
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

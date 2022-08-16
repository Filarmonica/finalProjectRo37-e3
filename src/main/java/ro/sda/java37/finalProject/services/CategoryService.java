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

  public CategoryDto createCategory(CategoryDto entity) {
    Category category = categoryMapper.convertToEntity(entity);
    categoryRepository.save(category);
    return categoryMapper.convertToDto(category);
  }

  public CategoryDto findById(Long id) {
    Category entityCategory = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
    return categoryMapper.convertToDto(entityCategory);
  }

  public void deleteById(Long id) {
    categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
    categoryRepository.deleteById(id);
  }

  public void updateById(Long id, CategoryDto categoryDto) {
    Category entity = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
    entity.setId(categoryDto.getId());
    entity.setName(categoryDto.getName());
    entity.setDescription(categoryDto.getDescription());
    categoryRepository.save(entity);
  }
}

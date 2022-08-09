package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.services.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @PostMapping
    public CategoryDto createOrderLine(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }
}

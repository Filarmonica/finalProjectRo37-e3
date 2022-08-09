package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.services.ProductService;

import java.util.List;

public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.findAllProducts();

    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
}

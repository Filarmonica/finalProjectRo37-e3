package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ProductDto> getAllProducts() {
    return productService.findAllProducts();
  }

  @PostMapping
  public ProductDto createProduct(@RequestBody ProductDto productDto) {
    return productService.createProduct(productDto);
  }

  @GetMapping("/delete/{id}")
  public void deleteProductById(@PathVariable("id") Long id) {
    productService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateProductById(@RequestBody ProductDto productDto, @PathVariable Long id) {
    productService.updateById(id, productDto);
  }
}

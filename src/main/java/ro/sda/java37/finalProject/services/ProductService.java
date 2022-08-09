package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.entities.Product;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.ProductRepository;


import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(product -> productMapper.convertToDto(product)).collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductDto form) {
        Product product = productMapper.convertToEntity(form);
        productRepository.save(product);
        return form;
    }

    public ProductDto findById(long id) {
        Product entityCategory = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        return productMapper.convertToDto(entityCategory);
    }

    public void deleteById(long id) {
        productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        productRepository.deleteById(id);
    }
}

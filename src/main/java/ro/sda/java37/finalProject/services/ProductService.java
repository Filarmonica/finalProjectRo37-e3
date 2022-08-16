package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.entities.Product;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public List<ProductDto> findAllProducts() {
    return productRepository.findAll().stream().map(product -> productMapper.convertToDto(product)).collect(Collectors.toList());
  }

  public ProductDto createProduct(ProductDto entity) {
    Product product = productMapper.convertToEntity(entity);
    productRepository.save(product);
    return productMapper.convertToDto(product);
  }

  public ProductDto findById(long id) {
    Product entityCategory = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Product with %s does not exist", id)));
    return productMapper.convertToDto(entityCategory);
  }

  public void deleteById(long id) {
    productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Product with %s does not exist", id)));
    productRepository.deleteById(id);
  }

  public void updateById(Long id, ProductDto productDto) {
    Product entity = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Product with %s does not exist", id)));
    entity.setId(productDto.getId());
    entity.setTitle(productDto.getTitle());
    entity.setDescription(productDto.getDescription());
    entity.setThumbnail(productDto.getThumbnail());
    entity.setCategory(productDto.getCategory());
    entity.setPrice(productDto.getPrice());
    entity.setProductType(productDto.getProductType());
    entity.setBrand(productDto.getBrand());
    productRepository.save(entity);
  }
}

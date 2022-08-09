package ro.sda.java37.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.entities.Product;
import ro.sda.java37.finalProject.repository.ProductRepository;

@Service
public class ProductMapper implements Mapper<Product, ProductDto> {

    private final ProductRepository productRepository;

    public ProductMapper(ProductRepository categoryRepository) {
        this.productRepository = categoryRepository;
    }

    @Override
    public ProductDto convertToDto(Product entity) {
        ProductDto productForm = new ProductDto();
        productForm.setId(entity.getId());
        productForm.setDescription(entity.getDescription());
        productForm.setThumbnail(entity.getThumbnail());
        productForm.setCategory(entity.getCategory());
        productForm.setPrice(entity.getPrice());
        productForm.setProductType(entity.getProductType());
        productForm.getBrand();
        return productForm;
    }

    @Override
    public Product convertToEntity(ProductDto dto) {
        Product product;
        if (dto.getId() != null) {
            product = productRepository.findById(dto.getId()).orElse(new Product());
        } else {
            product = new Product();
        }
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setThumbnail(dto.getThumbnail());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setProductType(dto.getProductType());
        product.getBrand();
        return product;
    }
}

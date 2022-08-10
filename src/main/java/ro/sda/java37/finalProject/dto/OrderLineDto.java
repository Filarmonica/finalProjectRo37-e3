package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Product;

@Data
public class OrderLineDto {
    private Long id;
    private Product product;
    private int numberOfProducts;
    private Double price;
}

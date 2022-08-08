package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderLine {
    private Product product;
    private Product price;
    private int products;
}

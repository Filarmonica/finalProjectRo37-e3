package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Data
public class OrderLine {
    @Id
    @GeneratedValue
    private Product product;
    private int numberOfProducts;
    private Product price;

}

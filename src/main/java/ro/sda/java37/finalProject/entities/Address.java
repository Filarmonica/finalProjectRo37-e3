package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String city;
    private String street;
    private int zipCode;


    public Address() {

    }
}

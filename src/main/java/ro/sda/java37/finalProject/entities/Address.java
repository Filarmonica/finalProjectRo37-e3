package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Address {
    private Long id;
    private String country;
    private String city;
    private String street;
    private int zipCode;



}

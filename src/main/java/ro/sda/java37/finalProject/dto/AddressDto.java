package ro.sda.java37.finalProject.dto;

import lombok.Data;

@Data
public class AddressDto {
        private String country;
        private String city;
        private String street;
        private int zipCode;

}

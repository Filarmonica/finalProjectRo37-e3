package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ro.sda.java37.finalProject.dto.AddressDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Data
public class User{
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String city;
    private AddressDto address;
    private boolean avatar;  //it has an avatar or not
    boolean role;  // it is admin or user

}
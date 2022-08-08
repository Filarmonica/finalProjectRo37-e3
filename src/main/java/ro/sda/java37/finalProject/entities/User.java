package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class User{
    private Long id;
    private String email;
    private String password;
    private String city;
    private Address address;
    private boolean avatar;  //it has an avatar or not
    boolean role;  // it is admin or user

}
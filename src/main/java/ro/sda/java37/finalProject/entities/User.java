package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String city;
    private String address;
    private boolean avatar;  //it has an avatar or not
    boolean role;  // it is admin or user

}
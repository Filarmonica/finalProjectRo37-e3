package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private boolean avatar;  //it has an avatar or not
    boolean role;  // it is admin or user

    public User() {

    }
}
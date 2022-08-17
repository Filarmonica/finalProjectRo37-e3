package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;
import ro.sda.java37.finalProject.enums.UserRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;

@Entity
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue
  private Long id;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @Email
  private String email;
  @NotEmpty
  private String password;
  @NotEmpty
  private String city;
  @NotEmpty
  private String address;
  private Boolean avatar;  //it has an avatar or not
  private UserRole role;


}

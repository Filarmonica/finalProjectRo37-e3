package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.enums.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
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
  private Boolean avatar;
  private UserRole role;
}

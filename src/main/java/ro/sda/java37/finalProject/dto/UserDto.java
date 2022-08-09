package ro.sda.java37.finalProject.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String city;
    private String address;
    private Boolean avatar;
    private Boolean role;
}

package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserDto> getAllUsers() {
    return userService.findAllUsers();
  }

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto) {
    return userService.createUser(userDto);
  }

  @GetMapping("/delete/{id}")
  public void deleteUserById(@PathVariable("id") Long id) {
    userService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCategoryById(@RequestBody UserDto userDto, @PathVariable Long id) {
    userService.updateById(id, userDto);
  }
}

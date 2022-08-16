package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.entities.User;
import ro.sda.java37.finalProject.enums.UserRole;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.exceptions.UserAlreadyExistsException;
import ro.sda.java37.finalProject.registration.EmailValidator;
import ro.sda.java37.finalProject.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private EmailValidator emailValidator;
  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  public List<UserDto> findAllUsers() {
    return userRepository.findAll().stream().map(user -> userMapper.convertToDto(user)).collect(Collectors.toList());
  }

  public UserDto createUser(UserDto entity) {
    User user = userMapper.convertToEntity(entity);
    userRepository.save(user);
    return userMapper.convertToDto(user);
  }

//  public UserDto findById(long id) {
//    User entityUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with %s does not exist", id)));
//    return userMapper.convertToDto(entityUser);
//  }

  public void deleteById(long id) {
    userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with %s does not exist", id)));
    userRepository.deleteById(id);
  }

  public void updateById(Long id, UserDto userDto) {
    User entity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with %s does not exist", id)));
    entity.setId(userDto.getId());
    entity.setFirstName(userDto.getFirstName());
    entity.setLastName(userDto.getLastName());
    entity.setEmail(userDto.getEmail());
    entity.setPassword(userDto.getPassword());
    entity.setCity(userDto.getCity());
    entity.setAddress(userDto.getAddress());
    entity.setAvatar(userDto.getAvatar());
    entity.setRole(userDto.getRole());
    userRepository.save(entity);
  }

  public void signUpUser(User userDto) {
    String email = userDto.getEmail();
    boolean isValidEmail = emailValidator.test(email);
    if (!isValidEmail) {
      throw new IllegalStateException("The email is not valid.");
    }

    boolean userExists = userRepository.findUserByEmail(userDto.getEmail()).isPresent();
    if (userExists) {
      throw new UserAlreadyExistsException("User with the e-mail" + email + " already exists.");
    }
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    user.setEmail(userDto.getEmail());
    user.setCity(userDto.getCity());
    user.setRole(UserRole.USER);
    userRepository.save(user);
  }
}



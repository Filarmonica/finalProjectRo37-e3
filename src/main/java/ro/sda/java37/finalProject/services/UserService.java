package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.entities.User;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


  public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(user -> userMapper.convertToDto(user)).collect(Collectors.toList());
    }

    public UserDto createUser(UserDto form) {
        User user = userMapper.convertToEntity(form);
        userRepository.save(user);
        return userMapper.convertToDto(user);
    }

    public UserDto findById(long id) {
        User entityUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with %s does not exist", id)));
        return userMapper.convertToDto(entityUser);
    }

    public void deleteById(long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("User with %s does not exist", id)));
        userRepository.deleteById(id);
    }
}



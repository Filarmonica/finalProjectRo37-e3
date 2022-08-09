package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.CategoryDto;
import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.entities.User;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.UserRepository;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> findAll() { return userRepository.findAll();
    }

    public void createUser(CategoryDto form) {
        User user = userMapper.convertToEntity(form);
        userRepository.save(user);
    }

    public UserDto findById(long id) {
        User entityUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        return userMapper.convertToDto(entityUser);
    }

    public void deleteById(long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Category with %s does not exist", id)));
        userRepository.deleteById(id);
    }
}



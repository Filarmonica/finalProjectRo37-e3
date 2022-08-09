package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.entities.User;
import ro.sda.java37.finalProject.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserMapper implements Mapper<User, UserDto> {
    private final UserRepository userRepository;

    @Override
    public UserDto convertToDto(User entity) {
        UserDto userForm = new UserDto();
        userForm.setId(entity.getId());
        userForm.setEmail(entity.getEmail());
        userForm.setPassword(entity.getPassword());
        userForm.setCity(entity.getCity());
        userForm.setAddress(entity.getAddress());
        userForm.setAvatar(entity.getAvatar());
        userForm.setRole(entity.getRole());
        return userForm;
    }

    @Override
    public User convertToEntity(UserDto dto) {
        User user;
        if (dto.getId() != null) {
            user = userRepository.findById(dto.getId()).orElse(new User());
        } else {
            user = new User();
        }
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCity(dto.getCity());
        user.setAddress(dto.getAddress());
        user.setAvatar(dto.getAvatar());
        user.setRole(dto.getRole());
        return user;
    }
}



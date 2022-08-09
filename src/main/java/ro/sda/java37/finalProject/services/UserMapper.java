package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.UserDto;
import ro.sda.java37.finalProject.entities.User;
import ro.sda.java37.finalProject.repository.UserRepository;

public class UserMapper implements Mapper<User,UserDto> {
    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto convertToDto(User entity) {
        UserDto userForm = new UserDto();
        userForm.setId(entity.getId());
        userForm.setParentCategory(entity.getParentCategory());
        userForm.setSubcategories(entity.getSubcategories());
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
        user.setParentCategory(dto.getParentCategory());
        user.setSubcategories(dto.getSubcategories());
        return user;
    }
}



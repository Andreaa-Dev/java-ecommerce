package com.example.ecomerce.mapper;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.dtos.UserDTO;
import com.example.ecomerce.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mapper {

    // should be id, name,email, password => email, password
    public UserDTO toDto(User user) {
        String name = user.getName();
        return new UserDTO(name);
    }

    public User toUser(UserCreationDTO userDTO) {
        String password = userDTO.getPassword();
        return new User(1,userDTO.getEmail(), userDTO.hashedPassword(password),"" );
    }
}

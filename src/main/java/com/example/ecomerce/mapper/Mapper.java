package com.example.ecomerce.mapper;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.dtos.UserDTO;
import com.example.ecomerce.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    // user dto: name
    // user: name, email,password
    public UserDTO toDto(User user) {
        String name = user.getName();
        return new UserDTO(name);
    }

    // user creation: email, password
    // user: id, email,password, name
    public User toUser(UserCreationDTO userDTO) {
        return new User(12,userDTO.getEmail(), userDTO.getPassword(),"nam" );
    }
}

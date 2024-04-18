package com.example.ecomerce.services;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.dtos.UserDTO;
import com.example.ecomerce.entities.UserEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServices {
    private static Map<String, UserEntity> userList =new HashMap<>(){{
        put("1", new UserEntity("1","test@gmail.com", "123"));
    }};


    public Collection<UserEntity> getAllUsers() {
        return userList.values();
    }

    public UserEntity getUserById(String userId) {
        return userList.get(userId);
    }

    public UserEntity createUser(UserCreationDTO userCreationDTODTO) {
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID().toString());
        userList.put(user.getId(), user);
        return user;
    }

    public UserEntity removeUser(String userId) {
        return userList.remove(userId);
    }
}

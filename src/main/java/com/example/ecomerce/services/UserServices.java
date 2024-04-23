package com.example.ecomerce.services;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServices {
    private static Map<String, User> userList =new HashMap<>(){{
        put("1", new User(1,"test@gmail.com", "123","test"));
    }};


    public Collection<User> getAllUsers() {

        return userList.values();
    }

    public User getUserById(Integer userId) {

        return userList.get(userId);
    }

    public User createUser(User user) {
        return user;
    }

    public User removeUser(Integer userId) {

        return userList.remove(userId);
    }
}

package com.example.ecomerce.services;

import com.example.ecomerce.model.User;
import com.example.ecomerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(Integer userId) {
       userRepository.deleteById(userId);
    }

    public User findUserByEmail(String userEmail){
       return userRepository.findByEmail(userEmail);
    }
}

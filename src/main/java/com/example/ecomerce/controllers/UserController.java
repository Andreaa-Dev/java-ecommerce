package com.example.ecomerce.controllers;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.entities.UserEntity;
import com.example.ecomerce.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public Collection<UserEntity> getUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/{userId}")
    public  UserEntity getUserById(@PathVariable String userId){
      return userServices.getUserById((userId));
    }

    @PostMapping("/")
    public  UserEntity createUser(@RequestBody UserCreationDTO userCreationDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userCreationDTO.getEmail());
        // String hashedPassword = passwordEncoder.encode(password);
        userEntity.setPassword(userCreationDTO.getPassword());
       userServices.createUser()
    }

}

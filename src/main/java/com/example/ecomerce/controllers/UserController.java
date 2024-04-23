package com.example.ecomerce.controllers;

import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.mapper.Mapper;
import com.example.ecomerce.model.User;
import com.example.ecomerce.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/api/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    private Mapper mapper;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("")
    public List<User> getUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userServices.getUserById(userId);
    }

    // register
    @PostMapping("/register")
    public User createUser(@RequestBody UserCreationDTO userCreationDTO){
        System.out.println(userCreationDTO);
        User user = mapper.toUser(userCreationDTO);
        return userServices.createUser(user);
    }


    @PostMapping("/login")
    public String logInUser(@RequestBody UserCreationDTO userCreationDTO){

        return "user token " ;
    }
}

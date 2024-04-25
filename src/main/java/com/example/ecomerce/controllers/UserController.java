package com.example.ecomerce.controllers;

import com.example.ecomerce.auth.JwtResponse;
import com.example.ecomerce.auth.JwtUtils;
import com.example.ecomerce.dtos.UserCreationDTO;
import com.example.ecomerce.mapper.Mapper;
import com.example.ecomerce.model.User;
import com.example.ecomerce.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    private Mapper mapper;


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userServices.getUserById(userId);
    }

    // register
    @PostMapping("/register")
    public User createUser(@RequestBody UserCreationDTO userCreationDTO) {

        System.out.println(userCreationDTO);
        User user = mapper.toUser(userCreationDTO);
        return userServices.createUser(user);
    }


    @PostMapping("/login")
    public ResponseEntity<?> logInUser(@RequestBody UserCreationDTO userCreationDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCreationDTO.getEmail(),
                        userCreationDTO.getPassword()
                )
        );

        // todo: check password match
        String jwt = jwtUtils.generateJwtToken(userCreationDTO.getEmail());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}

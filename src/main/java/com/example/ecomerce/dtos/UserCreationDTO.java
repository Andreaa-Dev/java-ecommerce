package com.example.ecomerce.dtos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserCreationDTO {

    private String email ;
    private String password;

    public UserCreationDTO(){

    }

    public UserCreationDTO(String email, String password, String name){
        this.email=email;
        this.password=password;
    }

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // add hashed password
    public String hashedPassword (String password){
        return  passwordEncoder.encode(this.password);
    }

}

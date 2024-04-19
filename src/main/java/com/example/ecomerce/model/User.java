package com.example.ecomerce.model;

import org.springframework.security.crypto.password.PasswordEncoder;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;


    public User(){
    }

    public User(String id, String email, String password, String name) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

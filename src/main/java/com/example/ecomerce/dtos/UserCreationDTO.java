package com.example.ecomerce.dtos;

public class UserCreationDTO {
    private String name;
    private String email ;
    private String password;

    public UserCreationDTO(){

    }

    public UserCreationDTO(String email, String password, String name){
        this.name=name;
        this.email=email;
        this.password=password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.tapu.urlshortenerapp.dto;
import javax.validation.constraints.NotBlank;

public class UserDTO {


    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }




}
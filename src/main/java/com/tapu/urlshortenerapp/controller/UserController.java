package com.tapu.urlshortenerapp.controller;

import com.example.urldemo.dto.UserDTO;
import com.example.urldemo.model.User;
import com.example.urldemo.service.UserService;
import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.model.User;
import com.tapu.urlshortenerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userdto){
        Optional<User> resultOptional = userService.saveCustomer(userdto);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}

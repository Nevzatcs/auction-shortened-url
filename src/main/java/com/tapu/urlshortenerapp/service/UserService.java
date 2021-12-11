package com.tapu.urlshortenerapp.service;

import com.example.urldemo.dto.UserDTO;
import com.example.urldemo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> saveCustomer(UserDTO userDTO);

    Optional<User> findUserById(Long userId);

    boolean isExistById(Long id);
}

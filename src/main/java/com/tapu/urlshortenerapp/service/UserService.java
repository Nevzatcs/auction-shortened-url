package com.tapu.urlshortenerapp.service;

import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> saveCustomer(UserDTO userDTO);

    Optional<User> findUserById(Long userId);

    boolean isExistById(Long id);
}

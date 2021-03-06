package com.tapu.urlshortenerapp.service;

import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.exceptions.UserIsAlreadyExistException;
import com.tapu.urlshortenerapp.mappers.UserMapper;
import com.tapu.urlshortenerapp.model.User;
import com.tapu.urlshortenerapp.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public Optional<User> saveUser(UserDTO userDTO){

        boolean isExist = userRepository.isExistsByUsername(userDTO.getUsername());

        if(isExist){
            throw new UserIsAlreadyExistException("This username is already used, Please change your username");
        }

        User user = userMapper.mapFromUserDTOtoUser(userDTO);

        return Optional.of(userRepository.save(user));
    }

    @Override
    @Transactional
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional
    public boolean isExistById(Long id){
        return userRepository.isExistsById(id);
    }


}

package com.tapu.urlshortenerapp.mappers;


import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User mapFromUserDTOtoUser(UserDTO userDTO);

}

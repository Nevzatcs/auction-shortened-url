package com.tapu.urlshortenerapp.service;

import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.mappers.UserMapper;
import com.tapu.urlshortenerapp.model.User;
import com.tapu.urlshortenerapp.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository mockUserRepository;

    @Mock
    UserMapper mockUserMapper;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    void saveCustomer() {
        // given
        User user = new User();
        user.setUsername("test");
        user.setId(1L);
        when(mockUserRepository.isExistsByUsername(any())).thenReturn(Boolean.FALSE);
        when(mockUserMapper.mapFromUserDTOtoUser(any())).thenReturn(user);
        when(mockUserRepository.save(any())).thenReturn(user);

        // when
        UserDTO dto = new UserDTO();
        User actual = this.userServiceImpl.saveCustomer(dto).get();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(user, actual),
                () -> assertEquals(user.getUsername(), actual.getUsername())
        );


    }

    @Test
    void findUserById() {
        //given
        User expected = new User();
        expected.setId(1L);
        when(mockUserRepository.findById(1L)).thenReturn(Optional.of(expected));

        //when

        User actual = this.userServiceImpl.findUserById(1L).get();

        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());


    }

    @Test
    void isExistById() {
        //given

        when(mockUserRepository.isExistsById(anyLong())).thenReturn(Boolean.TRUE);

        //when
        boolean actual = this.userServiceImpl.isExistById(1L);

        assertNotNull(actual);
        assertEquals(true, actual);

    }
}

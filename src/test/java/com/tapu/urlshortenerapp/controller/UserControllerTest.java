package com.tapu.urlshortenerapp.controller;

import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.model.User;
import com.tapu.urlshortenerapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService mockUserService;

    @InjectMocks
    UserController userController;

    @Test
    void saveUser() {
        // given
        User user = new User();
        user.setId(1L);
        Optional<User> expected = Optional.of(user);
        when(mockUserService.saveCustomer(any())).thenReturn(expected);

        // when
        UserDTO dto = new UserDTO();
        User actual = this.userController.saveUser(dto).getBody();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual),
                () -> assertEquals(user.getId(), actual.getId())
        );
    }
}

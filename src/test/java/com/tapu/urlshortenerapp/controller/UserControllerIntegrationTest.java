package com.tapu.urlshortenerapp.controller;


import com.tapu.urlshortenerapp.dto.UserDTO;
import com.tapu.urlshortenerapp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-default.properties")
public class UserControllerIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;



    @Mock
    private UserService userService;


    private String basePath = "http://localhost:8080";

 @Test
 public void shouldSaveUser(){
     UserDTO userDTO = new UserDTO("test02", "test02");
     userService.saveUser(userDTO);
     ResponseEntity<String> responseEntity = this.restTemplate
             .postForEntity(basePath + "/user/signup", userDTO, String.class);

     assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

 }



}

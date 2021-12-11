package com.tapu.urlshortenerapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
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
@TestPropertySource("classpath:application.properties")
public class UrlControllerIntegrationTest {

    private String basePath = "http://localhost:8080";

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void shouldReturnUserAllUrls()
    {

        Long userId=1L;
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(basePath +"/user/{userId}/url/list",String.class,userId);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void shouldReturnUrlDetailForUser(){
        String userId="1";
        String urlId="1";
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(basePath +"/user/{userId}/url/detail/{urlId}",String.class,userId, urlId);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void deleteUrlId(){
        Long userId=1L;
        Long urlId=3L;
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(basePath +"/user/{userId}/url/detail/{urlId}",String.class,userId, urlId);
        restTemplate.delete(basePath + "/user/{userId}/url/detail/{urlId}" , userId , urlId);


        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}

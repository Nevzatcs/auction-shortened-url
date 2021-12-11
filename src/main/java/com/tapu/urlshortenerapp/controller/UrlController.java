package com.tapu.urlshortenerapp.controller;

import com.example.urldemo.dto.UrlDTO;
import com.example.urldemo.dto.UrlResponseDTO;
import com.example.urldemo.model.Url;
import com.example.urldemo.model.User;
import com.example.urldemo.service.UrlService;
import com.example.urldemo.service.UserService;
import com.tapu.urlshortenerapp.dto.UrlDTO;
import com.tapu.urlshortenerapp.model.Url;
import com.tapu.urlshortenerapp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UrlController {

    private final UrlService urlService;
    private final UserService userService;

    public UrlController(UrlService urlService, UserService userService) {
        this.urlService = urlService;
        this.userService = userService;
    }

    @PostMapping("/user/{userId}/url/create")
    public ResponseEntity<?> produceShortLink(@RequestBody @Valid UrlDTO urlDTO, @PathVariable Long userId)
    {
       boolean exist = userService.isExistById(userId);

        if(exist) {
            Url urlToRet = urlService.generateShortLink(urlDTO, userId);

            Optional<User> users = userService.findUserById(userId);
            urlToRet.setUsers(users.get());

            UrlResponseDTO urlResponseDTO = new UrlResponseDTO();
            urlResponseDTO.setShortened(("http://localhost:8080/s/" + urlToRet.getShortened()));
            urlResponseDTO.setId(urlToRet.getId());

            urlService.saveUrl(urlToRet);
            return new ResponseEntity<>(urlResponseDTO, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/s/{shortLink}")
    public ResponseEntity<?> redirectToUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {

        Url urlToRet = urlService.getEncodedUrl(shortLink);

         if (!urlToRet.getShortened().isEmpty()){
             response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
             response.setHeader("Location", urlToRet.getUrl());
             response.flushBuffer();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/user/{userId}/url/list")
    public List<String> findAll(@PathVariable Long userId){
        return (urlService.findShortLinkByUserId(userId));
    }

    @GetMapping("/user/{userId}/url/detail/{urlId}")
    public List<String> getUrlDetail(@PathVariable Long userId, @PathVariable Long urlId){
        return (urlService.findShortLinkByUserIdAndId(userId,urlId));
    }


    @DeleteMapping("/user/{userId}/url/detail/{urlId}")
    public String deleteUrlId(@PathVariable Long userId, @PathVariable Long urlId){
        urlService.deleteById(userId, urlId);
        return "User with id: " + userId +" deleted his Url with id: " + urlId;

    }
}

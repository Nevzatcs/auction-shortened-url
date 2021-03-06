package com.tapu.urlshortenerapp.controller;

import com.tapu.urlshortenerapp.dto.UrlDTO;
import com.tapu.urlshortenerapp.dto.UrlResponseDTO;
import com.tapu.urlshortenerapp.model.Url;
import com.tapu.urlshortenerapp.model.User;
import com.tapu.urlshortenerapp.service.UrlService;
import com.tapu.urlshortenerapp.service.UserService;
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
            urlToRet.setUser(users.get());

            UrlResponseDTO urlResponseDTO = urlService.setResponseDetails(urlToRet);
            urlService.saveUrl(urlToRet);
            return new ResponseEntity<>(urlResponseDTO, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

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

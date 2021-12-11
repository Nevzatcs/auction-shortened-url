package com.tapu.urlshortenerapp.exceptions;

public class UserIsNotFoundException extends RuntimeException{
    public UserIsNotFoundException(String message) {
        super(message);
    }
}

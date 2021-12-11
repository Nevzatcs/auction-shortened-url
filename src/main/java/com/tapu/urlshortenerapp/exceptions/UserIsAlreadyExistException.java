package com.tapu.urlshortenerapp.exceptions;

public class UserIsAlreadyExistException extends RuntimeException{

    public UserIsAlreadyExistException(String message) {
        super(message);
    }
}

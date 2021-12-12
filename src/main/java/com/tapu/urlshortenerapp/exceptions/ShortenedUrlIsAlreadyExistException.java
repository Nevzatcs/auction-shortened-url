package com.tapu.urlshortenerapp.exceptions;

public class ShortenedUrlIsAlreadyExistException extends RuntimeException{
    public ShortenedUrlIsAlreadyExistException(String message) {
        super(message);
    }
}

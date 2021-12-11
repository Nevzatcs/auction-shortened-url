package com.tapu.urlshortenerapp.exceptions;

public class UrlIsNotFoundException extends RuntimeException{
    public UrlIsNotFoundException(String message) {
        super(message);
    }
}

package com.tapu.urlshortenerapp.dto;

import com.tapu.urlshortenerapp.model.AbstractBaseEntity;


public class UrlResponseDTO extends AbstractBaseEntity {
    private String shortened;

    public UrlResponseDTO(String shortened) {

        this.shortened = shortened;


    }

    public UrlResponseDTO() {
    }


    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }


    @Override
    public String toString() {
        return "UrlResponseDTO{" +
                "shortened='" + shortened + '\'' +
                '}';
    }


}

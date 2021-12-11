package com.tapu.urlshortenerapp.dto;

import org.hibernate.validator.constraints.URL;


public class UrlDTO {

    @URL(message = "Url should start with https or http")
    private String url;

    public UrlDTO( String url, String shortened) {

        this.url = url;
    }

    public UrlDTO() {
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +

                '}';
    }


}

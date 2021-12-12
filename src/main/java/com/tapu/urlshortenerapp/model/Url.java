package com.tapu.urlshortenerapp.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Url extends AbstractBaseEntity{

    private String url;
    private String shortened;

    public Url(String url, String shortened) {
        this.shortened = shortened;
        this.url = url;
    }

    public Url() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = users;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", shortened='" + shortened + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return 42;
    }

    @ManyToOne
    User user;
}

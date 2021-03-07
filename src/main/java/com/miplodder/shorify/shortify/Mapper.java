package com.miplodder.shorify.shortify;

import javax.persistence.*;

@Entity
@Table(name = "mapper")
public class Mapper {

    Mapper(String actualUrl, String shortenUrl) {
        this.actualUrl = actualUrl;
        this.shortenUrl = shortenUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String actualUrl;
    private String shortenUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActualUrl() {
        return actualUrl;
    }

    public void setActualUrl(String actualUrl) {
        this.actualUrl = actualUrl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }
}

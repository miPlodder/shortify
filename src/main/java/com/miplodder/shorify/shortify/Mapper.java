package com.miplodder.shorify.shortify;

import javax.persistence.*;

@Entity
@Table(name = "mapper")
public class Mapper {

    public Mapper() {

    }

    public Mapper(final String key, final String value, final String timeStamp) {
        this.key = key;
        this.value = value;
        this.timeStamp = timeStamp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String timeStamp;
    private String key;
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

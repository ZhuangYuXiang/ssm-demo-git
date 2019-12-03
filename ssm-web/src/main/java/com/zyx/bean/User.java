package com.zyx.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;


public class User implements Serializable {
    @JsonIgnore
    private int id;
    private String name;
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.infoshareacademy.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorJson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

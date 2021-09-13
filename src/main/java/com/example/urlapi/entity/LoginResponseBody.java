package com.example.urlapi.entity;

public class LoginResponseBody {
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponseBody(String token) {
        this.token = token;
    }
}

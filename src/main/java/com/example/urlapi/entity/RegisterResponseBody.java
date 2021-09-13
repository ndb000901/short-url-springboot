package com.example.urlapi.entity;

public class RegisterResponseBody {
    private int code;

    public RegisterResponseBody(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

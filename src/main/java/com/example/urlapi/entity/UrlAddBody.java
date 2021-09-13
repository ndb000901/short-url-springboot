package com.example.urlapi.entity;

import java.util.ArrayList;

public class UrlAddBody {
    private  String token;
    private ArrayList<UrlAdd> list;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<UrlAdd> getList() {
        return list;
    }

    public void setList(ArrayList<UrlAdd> list) {
        this.list = list;
    }
}

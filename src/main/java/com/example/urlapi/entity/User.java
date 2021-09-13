package com.example.urlapi.entity;

import org.joda.time.DateTime;

public class User {
    private int user_id;
    private String name;
    private String email;
    private String passwd;
    private DateTime created_datetime;
    private int user_level;
    private int vip_level;
    private DateTime vip_datetime;
    private int current_url;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public DateTime getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(DateTime created_datetime) {
        this.created_datetime = created_datetime;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public int getVip_level() {
        return vip_level;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

    public DateTime getVip_datetime() {
        return vip_datetime;
    }

    public void setVip_datetime(DateTime vip_datetime) {
        this.vip_datetime = vip_datetime;
    }

    public int getCurrent_url() {
        return current_url;
    }

    public void setCurrent_url(int current_url) {
        this.current_url = current_url;
    }
}

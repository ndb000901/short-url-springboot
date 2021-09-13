package com.example.urlapi.entity;

import org.joda.time.DateTime;

public class SessionUser {
    private String email;
    private String user_id;
    private String passwd;
    private DateTime validTime;

    public SessionUser(String email, String user_id, String passwd) {
        this.validTime = DateTime.now().plusDays(1);
        this.email = email;
        this.user_id = user_id;
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public DateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(DateTime validTime) {
        this.validTime = validTime;
    }
}

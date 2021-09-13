package com.example.urlapi.entity;

import org.joda.time.DateTime;

public class Captcha {
    private String code;
    private DateTime validTime;

    public Captcha(String code) {
        this.code = code;
        this.validTime = DateTime.now().plusMinutes(10);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(DateTime validTime) {
        this.validTime = validTime;
    }
}

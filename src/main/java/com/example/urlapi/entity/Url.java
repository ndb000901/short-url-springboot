package com.example.urlapi.entity;

import org.joda.time.DateTime;

public class Url {
    private String surl;
    private String lurl;
    private int click_count;
    private DateTime created_datetime;
    private int ower_id;
    private String alias;



    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getLurl() {
        return lurl;
    }

    public void setLurl(String lurl) {
        this.lurl = lurl;
    }

    public int getClick_count() {
        return click_count;
    }

    public void setClick_count(int click_count) {
        this.click_count = click_count;
    }

    public DateTime getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(DateTime created_datetime) {
        this.created_datetime = created_datetime;
    }

    public int getOwer_id() {
        return ower_id;
    }

    public void setOwer_id(int ower_id) {
        this.ower_id = ower_id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}


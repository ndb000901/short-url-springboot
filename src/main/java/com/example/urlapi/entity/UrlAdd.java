package com.example.urlapi.entity;

public class UrlAdd {
    private String lurl;
    private String alias;
    public UrlAdd() {
        this.lurl = "";
        this.alias = "";
    }

    public String getLurl() {
        return lurl;
    }

    public void setLurl(String lurl) {
        this.lurl = lurl;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

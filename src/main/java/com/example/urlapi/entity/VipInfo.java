package com.example.urlapi.entity;

public class VipInfo {
    private int vip_level;
    private String name;
    private int price_1;
    private int price_3;
    private int price_12;
    private int max;

    public VipInfo(int vip_level, String name, int price_1, int price_3, int price_12, int max) {
        this.vip_level = vip_level;
        this.name = name;
        this.price_1 = price_1;
        this.price_3 = price_3;
        this.price_12 = price_12;
        this.max = max;
    }

    public int getVip_level() {
        return vip_level;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice_1() {
        return price_1;
    }

    public void setPrice_1(int price_1) {
        this.price_1 = price_1;
    }

    public int getPrice_3() {
        return price_3;
    }

    public void setPrice_3(int price_3) {
        this.price_3 = price_3;
    }

    public int getPrice_12() {
        return price_12;
    }

    public void setPrice_12(int price_12) {
        this.price_12 = price_12;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

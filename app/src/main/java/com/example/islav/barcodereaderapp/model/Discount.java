package com.example.islav.barcodereaderapp.model;



public class Discount {
    private String name;
    private String discount_percent;
    private String code;
    private String path;

    public Discount(String name, String discount_percent) {
        this.name = name;
        this.discount_percent = discount_percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(String discount_percent) {
        this.discount_percent = discount_percent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

package com.example.islav.barcodereaderapp.model;



public class Discount {
    private String name;
    private String discount_percent;
    private String code;
    private String path;
    private int publicAccess;

    public int getPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(int publicAccess) {
        this.publicAccess = publicAccess;
    }

    public Discount(String name, String discount_percent, String barcode,int publicAccess) {
        this.name = name;
        this.discount_percent = discount_percent;
        this.code = barcode;
        this.publicAccess=publicAccess;
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

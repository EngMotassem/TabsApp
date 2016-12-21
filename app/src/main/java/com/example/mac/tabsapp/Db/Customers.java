package com.example.mac.tabsapp.Db;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class Customers {
    private int id,catid;
    private String name,des,imageUrl,lang,lat,phone;

    public Customers() {
    }

    public Customers(int id, int catid, String name, String des, String imageUrl, String lang, String lat, String phone) {
        this.id = id;
        this.catid = catid;
        this.name = name;
        this.des = des;
        this.imageUrl = imageUrl;
        this.lang = lang;
        this.lat = lat;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.example.mac.tabsapp.Db;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class Categories {
    private int id,image;
    private  String name,des,imageUrl;

    public Categories() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Categories(int id, String name, String des, String imageUrl) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.imageUrl = imageUrl;
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
}

package com.example.mac.tabsapp.Db;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class SpinnerData {
    private int id;
    private  String name;

    public SpinnerData() {
    }



    public SpinnerData(int id, String name) {
        this.id = id;
        this.name = name;

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

}

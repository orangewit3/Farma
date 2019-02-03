package com.example.myapplication;

public class Seller {

    private String name;
    private String location;
    private Crop crop;

    public Seller(String name, String location, Crop crop) {
        this.name = name;
        this.location = location;
        this.crop = crop;
    }

    public Crop getCrop() {
        return this.crop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
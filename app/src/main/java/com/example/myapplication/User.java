package com.example.myapplication;

public class User {

    private String company;
    private Crop desiredCrop;
    private int maxDistance;
    private int maxDeliveryTime;
    private int quantity;
    private double maxPrice;
    private String location;
    private boolean isGMO;

    public User(int deliveryTime, String location, double price, boolean isGMo) {
        maxDeliveryTime = deliveryTime;
        this.location = location;
        maxPrice = price;
        this.isGMO = isGMo;
    }
    public String getCompany() {
        return company;
    }
    public Crop getDesiredCrop() {
        return desiredCrop;
    }
    public int getMaxDistance() {
        return maxDistance;
    }
    public int getMaxDeliveryTime () {
        return maxDeliveryTime;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getMaxPrice () {
        return maxPrice;
    }

    public String getLocation() {
        return location;
    }

    public boolean getGMO() {
        return this.isGMO;
    }
}
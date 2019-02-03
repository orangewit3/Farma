package com.example.myapplication;

public class User {

    private String company;
    private Crop desiredCrop;
    private int maxDistance;
    private int maxDeliveryTime;
    private int quantity;
    private double maxPrice;

    public User(String company, Crop desired, int distance, int delivery, int quantityInBushels, double price) {
        this.company = company;
        desiredCrop = desired;
        maxDistance = distance;
        maxDeliveryTime = delivery;
        quantity = quantityInBushels;
        maxPrice = price;
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

}

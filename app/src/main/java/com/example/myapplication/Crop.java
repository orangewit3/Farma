package com.example.myapplication;

public class Crop {
    private String cropName;
    private boolean isGMO;
    private int daysFromHarvest;
    private boolean isOrganic;
    private double cost;
    /**
     *
     * @param name Name of the crop
     * @param gmo boolean if the crop is GMO or not
     * @param days The amount of days from the harvest
     */
    public Crop(String name, double cost, boolean gmo, int days) {
        cropName = name;
        isGMO = gmo;
        daysFromHarvest = days;
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    public String getName() {
        return cropName;
    }
    public boolean isGMO() {
        return isGMO;
    }

    public int getDaysFromHarvest() {
        return daysFromHarvest;
    }
}
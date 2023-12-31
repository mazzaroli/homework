package com.solvd.parser.models;


public class CPU {
    private String model;
    private String manufacturer;
    private double clockSpeed;

    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", clockSpeed=" + clockSpeed +
                '}';
    }
}
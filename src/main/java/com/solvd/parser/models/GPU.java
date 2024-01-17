package com.solvd.parser.models;

public class GPU {
    private String model;
    private int memory;
    private int clockSpeed;

    // Getters and setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "model='" + model + '\'' +
                ", memory=" + memory +
                ", clockSpeed=" + clockSpeed +
                '}';
    }
}
package com.solvd.parser.models;

public class Mouse {
    private String type;

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "type='" + type + '\'' +
                '}';
    }
}
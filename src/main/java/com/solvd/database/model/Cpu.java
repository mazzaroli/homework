package com.solvd.database.model;

public class Cpu {
    private Integer id;
    private String manufacturer;
    private double speed;
    private Integer Component_id;
    private Integer Computer_computer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Integer getComponent_id() {
        return Component_id;
    }

    public void setComponent_id(Integer component_id) {
        Component_id = component_id;
    }

    public Integer getComputer_computer_id() {
        return Computer_computer_id;
    }

    public void setComputer_computer_id(Integer computer_computer_id) {
        Computer_computer_id = computer_computer_id;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", speed=" + speed +
                ", Component_id=" + Component_id +
                ", Computer_computer_id=" + Computer_computer_id +
                '}';
    }
}
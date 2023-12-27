package com.solvd.database.model;

public class Gpu {
    private Integer id;
    private Integer memory;
    private Integer boostClock;
    private Integer Component_id;
    private Integer Computer_computer_id;
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(Integer boostClock) {
        this.boostClock = boostClock;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "id=" + id +
                ", memory=" + memory +
                ", boostClock=" + boostClock +
                ", Component_id=" + Component_id +
                ", Computer_computer_id=" + Computer_computer_id +
                ", price=" + price +
                '}';
    }
}
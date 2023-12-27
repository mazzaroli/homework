package com.solvd.database.model;

public class Ram {
    private Integer id;
    private Integer capacity;
    private Integer Computer_computer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getComputer_computer_id() {
        return Computer_computer_id;
    }

    public void setComputer_computer_id(Integer computer_computer_id) {
        Computer_computer_id = computer_computer_id;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", Computer_computer_id=" + Computer_computer_id +
                '}';
    }
}
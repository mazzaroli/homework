package com.solvd.parser.models;

import com.solvd.parser.DateXMLAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "laptop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Laptop {
//
    @XmlAttribute(name = "id")
    private int id;
    private String brand;
    private String model;
    @XmlJavaTypeAdapter(DateXMLAdapter.class)
    private Date manufactureDate;
    private List<RamSlots> ramSlots;
    private CPU cpu;
    private GPU gpu;
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public List<RamSlots> getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(List<RamSlots> ramSlots) {
        this.ramSlots = ramSlots;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", ramSlots=" + ramSlots +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", keyboard=" + keyboard +
                ", monitor=" + monitor +
                ", mouse=" + mouse +
                '}';
    }
}
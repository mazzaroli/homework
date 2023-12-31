package com.solvd.parser.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.parser.DateJacksonAdapter;
import com.solvd.parser.DateXMLAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "laptop")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "brand", "model", "manufactureDate", "ramSlots", "cpu", "graphicCard", "keyboard", "monitor", "mouse"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Laptop {
    @XmlAttribute(name = "id")
    private int id;
    @JsonProperty
    private String brand;
    @JsonProperty
    private String model;
    @JsonDeserialize(using = DateJacksonAdapter.class)
    @XmlJavaTypeAdapter(DateXMLAdapter.class)
    private Date manufactureDate;
    @JsonProperty
    private List<RamSlots> ramSlots;
    @JsonProperty
    private CPU cpu;
    @JsonProperty("graphicCard")
    private GPU gpu;
    @JsonProperty
    private Keyboard keyboard;
    @JsonProperty
    private Monitor monitor;
    @JsonProperty
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
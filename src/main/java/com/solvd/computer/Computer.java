package com.solvd.computer;
import com.solvd.components.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Computer Class
public class Computer {
    private static final Logger logger = LogManager.getLogger(Computer.class);

    // Fields for the Computer class
    private String brand;
    private String model;
    private boolean isUpgradable;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    // Default constructor for the Computer class
    public Computer(){
        setBrand("Default");
        setModel("Default");
        setUpgradable(false);
    }

    // Constructor for the Computer class
    public Computer(String brand, String model, boolean isUpgradable,CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        setBrand(brand);
        setModel(model);
        setUpgradable(isUpgradable);
        setCpu(cpu);
        setGpu(gpu);
        setRam(ram);
        setKeyboard(keyboard);
        setMonitor(monitor);
        setMouse(mouse);
    }

    // Override toString method
    @Override
    public String toString() {
        return "From Computer{ brand='" + getBrand() + "', model='" + getModel() + "', Upgradable='" + isUpgradable()+"' }";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        // Calculate hash code based on brand and model
        return 31 * getBrand().hashCode() + getModel().hashCode();
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return brand.equals(computer.brand) && model.equals(computer.model);
    }

    // Method to print brand and model info
    public void printInfo() {
        logger.info(brand + " " + model);
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

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
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

    public boolean isUpgradable() {
        return isUpgradable;
    }

    public void setUpgradable(boolean upgradable) {
        isUpgradable = upgradable;
    }
}
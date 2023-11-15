package com.solvd.devices;

import com.solvd.components.*;
import com.solvd.computer.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Desktop Class
public class Desktop extends Computer {
    private static final Logger logger = LogManager.getLogger(Desktop.class);

    // Field for the Desktop class
    private String formFactor;

    // Default constructor for Desktop
    public Desktop() {
        super();
        setFormFactor("Default");
        this.setCpu(new CPU());
        this.setGpu(new GPU());
        this.setRam(new RAM());
        this.setKeyboard(new Keyboard());
        this.setMonitor(new Monitor());
        this.setMouse(new Mouse());
    }

    // Constructor for the Desktop class
    public Desktop(String formFactor , String brand, String model, boolean isUpgradable, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model, isUpgradable, cpu, gpu, ram, keyboard, monitor, mouse);
        setFormFactor(formFactor);
        this.setCpu(cpu);
        this.setGpu(gpu);
        this.setRam(ram);
        this.setKeyboard(keyboard);
        this.setMonitor(monitor);
        this.setMouse(mouse);
    }

    // Override the printInfo method to print Desktop information
    @Override
    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Desktop: ").append("\n");
        sb.append(super.toString()).append("\n");
        sb.append("Form Factor: ").append(this.getFormFactor()).append("\n");
        sb.append("CPU: ").append(this.getCpu().getModel()).append("\n");
        sb.append("GPU: ").append(this.getGpu().getModel()).append("\n");
        sb.append("RAM: ").append(this.getRam().getCapacity()).append("\n");
        sb.append("Keyboard: ").append(this.getKeyboard().getType()).append("\n");
        sb.append("Monitor: ").append(this.getMonitor().getType()).append("\n");
        sb.append("Mouse: ").append(this.getMouse().getType()).append("\n");

        logger.info(sb.toString());
    }

    // Getters and setters for formFactor
    public String getFormFactor() {return formFactor;}
    public void setFormFactor(String formFactor) {this.formFactor = formFactor;}
}
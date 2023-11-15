package com.solvd.devices;

import com.solvd.components.*;
import com.solvd.computer.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Tablet Class
public class Tablet extends Computer {
    private static final Logger logger = LogManager.getLogger(Tablet.class);

    // Field for the Tablet class
    private boolean hasTouchPen;

    // Default constructor for Tablet
    public Tablet() {
        super();
        setHasTouchPen(false);
        this.setCpu(new CPU());
        this.setGpu(new GPU());
        this.setRam(new RAM());
        this.setKeyboard(new Keyboard());
        this.setMonitor(new Monitor());
        this.setMouse(new Mouse());
    }

    // Constructor for the Tablet class
    public Tablet(boolean hasTouchPen, String brand, boolean isUpgradable, String model, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model,isUpgradable, cpu, gpu, ram, keyboard, monitor, mouse);
        this.setHasTouchPen(hasTouchPen);
        this.setCpu(cpu);
        this.setGpu(gpu);
        this.setRam(ram);
        this.setKeyboard(keyboard);
        this.setMonitor(monitor);
        this.setMouse(mouse);
    }

    // Override the printInfo method to print Tablet information
    @Override
    public void printInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tablet: ").append("\n");
        sb.append(super.toString()).append("\n");
        sb.append("Touch Pen: ").append(this.getisHasTouchPen()).append("\n");
        sb.append("CPU: ").append(this.getCpu().getModel()).append("\n");
        sb.append("GPU: ").append(this.getGpu().getModel()).append("\n");
        sb.append("RAM: ").append(this.getRam().getCapacity()).append("\n");
        sb.append("Keyboard: ").append(this.getKeyboard().getType()).append("\n");
        sb.append("Monitor: ").append(this.getMonitor().getType()).append("\n");
        sb.append("Mouse: ").append(this.getMouse().getType()).append("\n");

        logger.info(sb.toString());
    }

    // Getters and setters for HasTouchPen
    public boolean getisHasTouchPen() {return hasTouchPen;}
    public void setHasTouchPen(boolean hasTouchPen) {this.hasTouchPen = hasTouchPen;}
}
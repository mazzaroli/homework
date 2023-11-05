package homework_10_30_23.devices;

import homework_10_30_23.components.*;
import homework_10_30_23.computer.Computer;

// Tablet Class
public class Tablet extends Computer {
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
    public Tablet(boolean hasTouchPen, String brand, String model, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model, cpu, gpu, ram, keyboard, monitor, mouse);
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
        System.out.print("Tablet: ");
        super.printInfo();
        System.out.println("Touch Pen: " + this.getisHasTouchPen() +
                " CPU: " + this.getCpu().getModel() +
                ", GPU: " + this.getGpu().getModel() +
                ", RAM: " + this.getRam().getCapacity() +
                ", Keyboard: " + this.getKeyboard().getType() +
                ", Monitor: " + this.getMonitor().getType() +
                ", Mouse: " + this.getMouse().getType());
    }

    // Getters and setters for HasTouchPen
    public boolean getisHasTouchPen() {return hasTouchPen;}
    public void setHasTouchPen(boolean hasTouchPen) {this.hasTouchPen = hasTouchPen;}
}
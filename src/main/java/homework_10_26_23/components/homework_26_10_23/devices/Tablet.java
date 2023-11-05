package homework_10_26_23.components.homework_26_10_23.devices;

import homework_10_26_23.components.homework_26_10_23.components.*;
import homework_10_26_23.components.homework_26_10_23.computer.Computer;

// Tablet Class
public class Tablet extends Computer {
    private boolean hasTouchPen;

    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    // Default constructor
    public Tablet() {
        this.hasTouchPen = false;

        this.cpu = new CPU("Default");
        this.gpu = new GPU("Default");
        this.ram = new RAM(8); // Default RAM size in gigabytes
        this.keyboard = new Keyboard("Default");
        this.monitor = new Monitor("Default");
        this.mouse = new Mouse("Default");
    }

    // Constructor for the Tablet class
    public Tablet(boolean hasTouchPen, String brand, String model, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model);
        this.hasTouchPen = hasTouchPen;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Touch Pen: " + this.hasTouchPen +
                " CPU: " + this.cpu.getModel() +
                ", GPU: " + this.gpu.getModel() +
                ", RAM: " + this.ram.getCapacity() +
                ", Keyboard: " + this.keyboard.getType() +
                ", Monitor: " + this.monitor.getType() +
                ", Mouse: " + this.mouse.getType());
    }
    // Getters and setters for HasTouchPen
    public boolean isHasTouchPen() {return hasTouchPen;}
    public void setHasTouchPen(boolean hasTouchPen) {this.hasTouchPen = hasTouchPen;}

    // Getters and setters for CPU
    public CPU getCpu() { return cpu; }
    public void setCpu(CPU cpu) { this.cpu = cpu; }

    // Getters and setters for GPU
    public GPU getGpu() { return gpu; }
    public void setGpu(GPU gpu) { this.gpu = gpu; }

    // Getters and setters for RAM
    public RAM getRam() { return ram; }
    public void setRam(RAM ram) { this.ram = ram; }

    // Getters and setters for Keyboard
    public Keyboard getKeyboard() { return keyboard; }
    public void setKeyboard(Keyboard keyboard) { this.keyboard = keyboard; }

    // Getters and setters for Monitor
    public Monitor getMonitor() { return monitor; }
    public void setMonitor(Monitor monitor) { this.monitor = monitor; }

    // Getters and setters for Mouse
    public Mouse getMouse() { return mouse; }
    public void setMouse(Mouse mouse) { this.mouse = mouse; }
}
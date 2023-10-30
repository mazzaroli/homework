package homework_26_10_23.devices;

import homework_26_10_23.components.Keyboard;
import homework_26_10_23.components.Mouse;
import homework_26_10_23.components.Monitor;
import homework_26_10_23.components.CPU;
import homework_26_10_23.components.GPU;
import homework_26_10_23.components.RAM;
import homework_26_10_23.computer.Computer;

// Laptop Class
public class Laptop extends Computer {
    private int batteryLifeInHours;

    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    // Default constructor
    public Laptop() {
        this.batteryLifeInHours = 0;
        this.cpu = new CPU("Default");
        this.gpu = new GPU("Default");
        this.ram = new RAM(8); // Default RAM size in gigabytes
        this.keyboard = new Keyboard("Default");
        this.monitor = new Monitor("Default");
        this.mouse = new Mouse("Default");
    }

    // Constructor for the Laptop class
    public Laptop(int batteryLifeInHours, String brand, String model, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model);
        this.batteryLifeInHours = batteryLifeInHours;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        // Additional info for Tablet
        System.out.println(" Battery Life In Hours: " + this.batteryLifeInHours+
                " CPU: " + this.cpu.getModel() +
                ", GPU: " + this.gpu.getModel() +
                ", RAM: " + this.ram.getCapacity() +
                ", Keyboard: " + this.keyboard.getType() +
                ", Monitor: " + this.monitor.getType() +
                ", Mouse: " + this.mouse.getType());

    }

    // Getters and setters for BatteryLifeInHours
    public int getBatteryLifeInHours() {return batteryLifeInHours;}
    public void setBatteryLifeInHours(int batteryLifeInHours) {this.batteryLifeInHours = batteryLifeInHours;}

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

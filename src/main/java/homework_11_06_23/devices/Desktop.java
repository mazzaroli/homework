package homework_11_06_23.devices;

import homework_11_02_23.components.*;
import homework_11_02_23.computer.Computer;

// Desktop Class
public class Desktop extends Computer {
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
        System.out.print("Desktop: ");
        super.printInfo();
        // Additional info for Desktop
        System.out.println(" Form Factor: " + this.getFormFactor() +
                " CPU: " + this.getCpu().getModel() +
                ", GPU: " + this.getGpu().getModel() +
                ", RAM: " + this.getRam().getCapacity() +
                ", Keyboard: " + this.getKeyboard().getType() +
                ", Monitor: " + this.getMonitor().getType() +
                ", Mouse: " + this.getMouse().getType());
    }

    // Getters and setters for formFactor
    public String getFormFactor() {return formFactor;}
    public void setFormFactor(String formFactor) {this.formFactor = formFactor;}
}

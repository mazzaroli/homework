package homework_11_02_23.devices;

import homework_11_02_23.components.Mouse;
import homework_11_02_23.computer.Computer;

// Desktop Class
public class Desktop extends Computer {
    // Field for the Desktop class
    private String formFactor;

    // Default constructor for Desktop
    public Desktop() {
        super();
        setFormFactor("Default");
        this.setCpu(new homework_11_02_23.components.CPU());
        this.setGpu(new homework_11_02_23.components.GPU());
        this.setRam(new homework_11_02_23.components.RAM());
        this.setKeyboard(new homework_11_02_23.components.Keyboard());
        this.setMonitor(new homework_11_02_23.components.Monitor());
        this.setMouse(new homework_11_02_23.components.Mouse());
    }

    // Constructor for the Desktop class
    public Desktop(String formFactor , String brand, String model, homework_11_02_23.components.CPU cpu, homework_11_02_23.components.GPU gpu, homework_11_02_23.components.RAM ram, homework_11_02_23.components.Keyboard keyboard, homework_11_02_23.components.Monitor monitor, Mouse mouse) {
        super(brand, model, cpu, gpu, ram, keyboard, monitor, mouse);
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

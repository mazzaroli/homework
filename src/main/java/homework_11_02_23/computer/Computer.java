package homework_11_02_23.computer;

import homework_11_02_23.components.Mouse;

// Computer Class
public class Computer {
    // Fields for the Computer class
    private String brand;
    private String model;
    private homework_11_02_23.components.CPU cpu;
    private homework_11_02_23.components.GPU gpu;
    private homework_11_02_23.components.RAM ram;
    private homework_11_02_23.components.Keyboard keyboard;
    private homework_11_02_23.components.Monitor monitor;
    private homework_11_02_23.components.Mouse mouse;

    // Default constructor for the Computer class
    public Computer(){
        setBrand("Default");
        setModel("Default");
    }

    // Constructor for the Computer class
    public Computer(String brand, String model, homework_11_02_23.components.CPU cpu, homework_11_02_23.components.GPU gpu, homework_11_02_23.components.RAM ram, homework_11_02_23.components.Keyboard keyboard, homework_11_02_23.components.Monitor monitor, homework_11_02_23.components.Mouse mouse) {
        setBrand(brand);
        setModel(model);
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
        return "From Computer{ brand='" + getBrand() + "', model='" + getModel() + "' }";
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
        System.out.println(brand +" "+ model);
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

    public homework_11_02_23.components.CPU getCpu() {
        return cpu;
    }

    public void setCpu(homework_11_02_23.components.CPU cpu) {
        this.cpu = cpu;
    }

    public homework_11_02_23.components.GPU getGpu() {
        return gpu;
    }

    public void setGpu(homework_11_02_23.components.GPU gpu) {
        this.gpu = gpu;
    }

    public homework_11_02_23.components.RAM getRam() {
        return ram;
    }

    public void setRam(homework_11_02_23.components.RAM ram) {
        this.ram = ram;
    }

    public homework_11_02_23.components.Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(homework_11_02_23.components.Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public homework_11_02_23.components.Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(homework_11_02_23.components.Monitor monitor) {
        this.monitor = monitor;
    }

    public homework_11_02_23.components.Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}





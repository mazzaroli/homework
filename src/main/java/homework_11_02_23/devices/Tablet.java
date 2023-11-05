package homework_11_02_23.devices;

import homework_11_02_23.components.Mouse;
import homework_11_02_23.computer.Computer;

// Tablet Class
public class Tablet extends Computer {
    // Field for the Tablet class
    private boolean hasTouchPen;

    // Default constructor for Tablet
    public Tablet() {
        super();
        setHasTouchPen(false);
        this.setCpu(new homework_11_02_23.components.CPU());
        this.setGpu(new homework_11_02_23.components.GPU());
        this.setRam(new homework_11_02_23.components.RAM());
        this.setKeyboard(new homework_11_02_23.components.Keyboard());
        this.setMonitor(new homework_11_02_23.components.Monitor());
        this.setMouse(new homework_11_02_23.components.Mouse());
    }

    // Constructor for the Tablet class
    public Tablet(boolean hasTouchPen, String brand, boolean isUpgradable, String model, homework_11_02_23.components.CPU cpu, homework_11_02_23.components.GPU gpu, homework_11_02_23.components.RAM ram, homework_11_02_23.components.Keyboard keyboard, homework_11_02_23.components.Monitor monitor, Mouse mouse) {
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
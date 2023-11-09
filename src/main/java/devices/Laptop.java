package devices;

import components.*;
import computer.Computer;
import interfaces.Upgradable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Laptop Class
public class Laptop extends Computer implements Upgradable {
    private static final Logger logger = LogManager.getLogger(Laptop.class);

    // Field for the Laptop class
    private int batteryLifeInHours;

    // Default constructor for Laptop
    public Laptop() {
        super();
        setBatteryLifeInHours(0);
        this.setCpu(new CPU());
        this.setGpu(new GPU());
        this.setRam(new RAM());
        this.setKeyboard(new Keyboard());
        this.setMonitor(new Monitor());
        this.setMouse(new Mouse());
    }

    // Constructor for the Laptop class
    public Laptop(int batteryLifeInHours, String brand, String model, boolean isUpgradable, CPU cpu, GPU gpu, RAM ram, Keyboard keyboard, Monitor monitor, Mouse mouse) {
        super(brand, model, isUpgradable, cpu, gpu, ram, keyboard, monitor, mouse);
        setBatteryLifeInHours(batteryLifeInHours);
        this.setCpu(cpu);
        this.setGpu(gpu);
        this.setRam(ram);
        this.setKeyboard(keyboard);
        this.setMonitor(monitor);
        this.setMouse(mouse);
    }

    // Override the printInfo method to print Laptop information
    @Override
    public void printInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Laptop: ").append("\n");
        sb.append(super.toString()).append("\n");
        sb.append("Battery Life In Hours: ").append(getBatteryLifeInHours()).append("\n");
        sb.append("CPU: ").append(this.getCpu().getModel()).append("\n");
        sb.append("GPU: ").append(this.getGpu().getModel()).append("\n");
        sb.append("RAM: ").append(this.getRam().getCapacity()).append("\n");
        sb.append("Keyboard: ").append(this.getKeyboard().getType()).append("\n");
        sb.append("Monitor: ").append(this.getMonitor().getType()).append("\n");
        sb.append("Mouse: ").append(this.getMouse().getType()).append("\n");

        logger.info(sb.toString());

    }

    // Check if the device is upgradable and perform the upgrade if possible; otherwise, indicate that it is not upgradable
    @Override
    public void upgrade() {
        if (super.isUpgradable()) {
            logger.info("Laptop is upgradable. Performing the upgrade...");
        } else {
            logger.info("Laptop is not upgradable.");
        }
    }


    // Getter method for BatteryLifeInHours
    public int getBatteryLifeInHours() {
        return batteryLifeInHours;
    }

    // Setter method for BatteryLifeInHours
    public void setBatteryLifeInHours(int batteryLifeInHours) {
        this.batteryLifeInHours = batteryLifeInHours;
    }
}
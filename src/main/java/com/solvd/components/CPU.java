package com.solvd.components;

import com.solvd.exceptions.NoGhzException;
import com.solvd.loggers.FileLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// CPU Class
public class CPU extends Component {
    private final static Logger LOGGER = LogManager.getLogger(CPU.class);
    // Fields for the CPU class
    protected String manufacturer;
    protected double speed;

    // Default constructor for the CPU class
    public CPU() {
        setManufacturer("Default");
        setSpeed(0);
    }

    // Constructor for the CPU class with specified attributes
    public CPU(String model, String manufacturer, double speed) throws NoGhzException {
        super(model);
        setManufacturer(manufacturer);

        if (speed == 0) {
            NoGhzException ghzException = new NoGhzException("The ghz is 0, it cannot be 0");
            FileLogger.logToFile(ghzException.getMessage());
            LOGGER.error(ghzException.getMessage());
            throw new NoGhzException(ghzException.getMessage());
        } else {
            setSpeed(speed);
        }
    }

    // Method to display CPU details
    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("CPU Details:\n")
                .append("Model: ").append(getModel()).append("\n")
                .append("Manufacturer: ").append(getManufacturer()).append("\n")
                .append("Speed: ").append(getSpeed()).append(" GHz");
        LOGGER.info(sb);
    }

    // Override toString method
    @Override
    public String toString() {
        return "CPU{ manufacturer='" + getManufacturer() + "', speed=" + getSpeed() + " }";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        // Calculate hash code based on manufacturer and speed
        return (int) (31 * manufacturer.hashCode() + speed);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CPU cpu = (CPU) obj;
        return manufacturer.equals(cpu.manufacturer) && speed == cpu.speed;
    }

    // Getter method for Manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    // Setter method for Manufacturer
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter method for Speed
    public double getSpeed() {
        return speed;
    }

    // Setter method for Speed
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
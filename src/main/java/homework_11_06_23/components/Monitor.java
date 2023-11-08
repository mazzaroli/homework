package homework_11_06_23.components;

import homework_11_06_23.interfaces.Powerable;

// Monitor Class
public class Monitor implements Powerable {
    // Field for the Monitor class
    private String type;

    // Default constructor for Monitor, setting the type to "Default"
    public Monitor() {
        setType("Default");
    }

    // Constructor for Monitor with a specified type
    public Monitor(String type) {
        setType(type);
    }

    @Override
    public void powerOn() {
        System.out.println("The monitor is powered on.");
    }

    @Override
    public void powerOff() {
        System.out.println("The monitor is powered off");
    }

    // Override toString method to provide a meaningful string representation
    @Override
    public String toString() {
        return "Monitor{ resolution='" + type + "' }";
    }

    // Override hashCode method to calculate the hash code based on the resolution
    @Override
    public int hashCode() {
        return 31 * type.hashCode();
    }

    // Override equals method to compare Monitor objects based on the type
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Monitor monitor = (Monitor) obj;
        return getType().equals(monitor.type);
    }

    // Getter method to retrieve the type of the monitor
    public String getType() {
        return type;
    }

    // Setter method to set the type of the monitor
    public void setType(String type) {
        this.type = type;
    }
}
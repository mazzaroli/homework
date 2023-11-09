package components;

import exceptions.MonitorAlreadyOffException;
import exceptions.MonitorAlreadyOnException;
import interfaces.Powerable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Monitor Class
public class Monitor implements Powerable {
    private static final Logger LOGGER = LogManager.getLogger(Monitor.class);

    // Field for the Monitor class
    private String type;
    private boolean isPoweredOn;

    // Default constructor for Monitor, setting the type to "Default"
    public Monitor() {
        setType("Default");

    }

    // Constructor for Monitor with a specified type
    public Monitor(String type, boolean isPoweredOn) throws MonitorAlreadyOffException, MonitorAlreadyOnException{
        setType(type);
        try {
            setPoweredOn(isPoweredOn);
        } catch (MonitorAlreadyOnException e) {
            // Manejo de la excepción si el monitor ya está encendido
            System.out.println("El monitor ya está encendido.");
        } catch (MonitorAlreadyOffException e) {
            // Manejo de la excepción si el monitor ya está apagado
            System.out.println("El monitor ya está apagado.");
        }
    }

    @Override
    public void powerOn() {
        if (isPoweredOn) {
            LOGGER.warn("Monitor is already powered on.");
        }
        isPoweredOn = true;
        LOGGER.info("The monitor is powered on.");
    }

    @Override
    public void powerOff() {
        if (!isPoweredOn) {
            LOGGER.warn("Monitor is already powered off.");
        }
        isPoweredOn = false;
        LOGGER.info("The monitor is powered off");
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

    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    public void setPoweredOn(boolean poweredOn) throws MonitorAlreadyOnException, MonitorAlreadyOffException {
        if (poweredOn && isPoweredOn) {
            throw new MonitorAlreadyOnException("The monitor is already powered on.");
        } else if (!poweredOn && !isPoweredOn) {
            throw new MonitorAlreadyOffException("The monitor is already powered off.");
        } else {
            this.isPoweredOn = poweredOn;
        }
    }
}
// Importing necessary components and exceptions
import components.*;
import exceptions.*;

// Main Class
public class Main {
    public static void main(String[] args)  {
        // Creating instances of CPU, GPU, RAM, Keyboard, Monitor, and Mouse
        CPU cpu = null;
        try {
            // Creating a CPU instance with model "Core i7", manufacturer "Intel", and 1 GHz
            cpu = new CPU("Core i7", "Intel", 1);
        } catch (NoGhzException e) {
            // Handling the exception if GHz value is not provided
            throw new RuntimeException(e);
        }

        Keyboard keyboard = null;
        try {
            // Creating a Keyboard instance with type "Mechanical"
            keyboard = new Keyboard("Mechanical");
        } catch (InvalidKeyboardTypeException e) {
            // Handling the exception if an invalid keyboard type is provided
            throw new RuntimeException(e);
        }

        Monitor monitor = null;
        try {
            // Creating a Monitor instance with specifications "27-inch 4K" and initially turned off
            monitor = new Monitor("27-inch 4K", true);
        } catch (MonitorAlreadyOffException | MonitorAlreadyOnException e) {
            // Handling the exceptions if the monitor is already off or on
            throw new RuntimeException(e);
        }

        Mouse mouse = null;
        try {
            // Creating a Mouse instance with type "Wireless" and initially configured as true
            mouse = new Mouse("Wireless", true);
        } catch (MouseNotConfigurableException e) {
            // Handling the exception if the mouse configuration is not valid
            throw new RuntimeException(e);
        }
    }
}
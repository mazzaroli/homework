package components;

import exceptions.InvalidKeyboardTypeException;
import interfaces.Connectable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Keyboard Class
public class Keyboard implements Connectable {
    private static final Logger LOGGER = LogManager.getLogger(Keyboard.class);

    // Private field for the type of the keyboard
    private String type;

    // Default constructor for Keyboard, setting the type to "Default"
    public Keyboard() {
        setType("Default");
    }

    // Constructor for Keyboard with a specified type
    public Keyboard(String type) {
        setType(type);
    }

    @Override
    public void connect() throws InvalidKeyboardTypeException {
        if (!(type.equals("Mechanical") && !getType().equals("Membrane"))) {
            String errorMessage = "Invalid keyboard type. Only Mechanical or Membrane keyboards are allowed.";
            LOGGER.error(errorMessage);
            throw new InvalidKeyboardTypeException(errorMessage);
        }
        LOGGER.info("Keyboard connected.");
    }

    // Getter method to retrieve the type of the keyboard
    public String getType() {
        return type;
    }

    // Setter method to set the type of the keyboard
    public void setType(String type) {
        this.type = type;
    }
}
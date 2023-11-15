package com.solvd.components;

import com.solvd.exceptions.InvalidKeyboardTypeException;
import com.solvd.interfaces.Connectable;
import com.solvd.loggers.FileLogger;
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
    public Keyboard(String type) throws InvalidKeyboardTypeException {
        if (!(type.equals("Mechanical") || type.equals("Membrane")) ) {
            String errorMessage = "Invalid keyboard type. Only Mechanical or Membrane keyboards are allowed. \nYou give: ";
            InvalidKeyboardTypeException invalidKeyboardTypeException = new InvalidKeyboardTypeException(errorMessage + type);
            FileLogger.logToFile(invalidKeyboardTypeException.getMessage());
            LOGGER.error(invalidKeyboardTypeException.getMessage());
            throw new InvalidKeyboardTypeException(invalidKeyboardTypeException.getMessage());
        } else {
            setType(type);
        }
    }

    @Override
    public void connect() {
        LOGGER.info("The keyboard is connected");
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

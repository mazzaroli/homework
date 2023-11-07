package homework_11_06_23.components;

import homework_11_06_23.interfaces.Connectable;

// Keyboard Class
public class Keyboard implements Connectable {
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
    public void connect() {
        System.out.println("Keyboard connected.");
        // Add connect logic for the keyboard here
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
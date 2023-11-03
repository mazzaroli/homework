package homework_11_02_23.components;

// Keyboard Class
public class Keyboard {
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

    // Getter method to retrieve the type of the keyboard
    public String getType() {
        return type;
    }

    // Setter method to set the type of the keyboard
    public void setType(String type) {
        this.type = type;
    }
}
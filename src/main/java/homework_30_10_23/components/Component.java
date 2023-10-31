package homework_30_10_23.components;

// This is the abstract class for computer components
public abstract class Component extends Object {
    // The model of the component
    protected String model;

    // Constructor for the Component class
    public Component(String model) {
        // TODO: Initialize the model
    }

    // Getter for the model
    public String getModel() {
        return model;
    }

    // Setter for the model
    public void setModel(String model) {
        this.model = model;
    }

    // Abstract method for displaying component details
    public abstract void displayDetails();
}

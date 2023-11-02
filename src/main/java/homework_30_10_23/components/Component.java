package homework_30_10_23.components;

// This is the abstract class for computer components
public abstract class Component {
    // The model of the component
    protected String model;

    // Default constructor for the Component class
    public Component() {
        // Setting the model to "Default" in the default constructor
        setModel("Default");
    }

    // Constructor for the Component class with a specified model
    public Component(String model) {
        setModel(model);
    }

    // Getter method to retrieve the model of the component
    public String getModel() {
        return model;
    }

    // Setter method to set the model of the component
    public void setModel(String model) {
        this.model = model;
    }

    // Abstract method for displaying component details, to be implemented by subclasses
    public abstract void displayDetails();
}

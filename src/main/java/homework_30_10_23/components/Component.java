package homework_30_10_23.components;

public abstract class Component extends Object
{
    protected String model;

    public Component(String model) {}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public abstract void displayDetails();
}

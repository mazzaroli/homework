package homework_10_26_23.computer;

// Computer Class
public class Computer {
    private String brand;
    private String model;


    public Computer(){
        this.brand = "Default";
        this.model = "Default";
    }

    // Constructor for the Computer class
    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Method to print brand and model info
    public void printInfo() {
        System.out.println(brand +" "+ model);
    }

    // Getter for brand
    public String getBrand() { return brand; }

    // Setter for brand
    public void setBrand(String brand) { this.brand = brand; }

    // Getter for model
    public String getModel() { return model; }

    // Setter for model
    public void setModel(String model) { this.model = model; }
}




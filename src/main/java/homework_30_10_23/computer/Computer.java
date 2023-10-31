package homework_30_10_23.computer;

// Computer Class
public class Computer extends Object{
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

    @Override
    public String toString() {
        return "From Computer{ brand='" + brand + "', model='" + model + "' }";
    }

    @Override
    public int hashCode() {
        // Calculate hash code based on brand and model
        return 31 * brand.hashCode() + model.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return brand.equals(computer.brand) && model.equals(computer.model);
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




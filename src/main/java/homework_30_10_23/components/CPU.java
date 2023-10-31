package homework_30_10_23.components;

// CPU Class
public class CPU extends Component{
    // Fields for the CPU class
    protected String manufacturer;
    protected double speed;

    // Constructor for the CPU class
    public CPU(String model, String manufacturer, double speed) {
        super(model);
        this.manufacturer = manufacturer;
        this.speed = speed;
    }

    // Method to display CPU details
    @Override
    public void displayDetails() {
        System.out.println("CPU Details:");
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Speed: " + speed + " GHz");
    }

    // Override toString method
    @Override
    public String toString() {
        return "CPU{ manufacturer='" + manufacturer + "', speed=" + speed + " }";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        // Calculate hash code based on manufacturer and speed
        return (int) (31 * manufacturer.hashCode() + speed);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CPU cpu = (CPU) obj;
        return manufacturer.equals(cpu.manufacturer) && speed == cpu.speed;
    }

    // Getters and setters for Manufacturer
    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}

    // Getters and setters for Speed
    public double getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
}
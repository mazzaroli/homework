package homework_30_10_23.components;

// CPU Class
public class CPU extends Component {
    // Fields for the CPU class
    protected String manufacturer;
    protected double speed;

    // Default constructor for the CPU class
    public CPU() {
        setManufacturer("Default");
        setSpeed(0);
    }

    // Constructor for the CPU class with specified attributes
    public CPU(String model, String manufacturer, double speed) {
        super(model);
        setManufacturer(manufacturer);
        setSpeed(speed);
    }

    // Method to display CPU details
    @Override
    public void displayDetails() {
        System.out.println("CPU Details:");
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Speed: " + getSpeed() + " GHz");
    }

    // Override toString method
    @Override
    public String toString() {
        return "CPU{ manufacturer='" + getManufacturer() + "', speed=" + getSpeed() + " }";
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

    // Getter method for Manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    // Setter method for Manufacturer
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter method for Speed
    public double getSpeed() {
        return speed;
    }

    // Setter method for Speed
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
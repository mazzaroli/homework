package homework_11_02_23.components;

// GPU Class
public class GPU extends Component {
    // Fields for the GPU class
    protected int memory;
    protected int boostClock;

    // Default constructor for GPU
    public GPU() {
        setMemory(0);
        setBoostClock(0);
    }

    // Constructor for GPU with specified attributes
    public GPU(String model, int memory, int boostClock) {
        super(model);
        setMemory(memory);
        setBoostClock(boostClock);
    }

    // Method to display GPU details
    @Override
    public void displayDetails() {
        System.out.println("GPU Details:");
        System.out.println("Model: " + getModel());
        System.out.println("Video Memory: " + getMemory() + "GB");
        System.out.println("Boost Clock: " + getBoostClock() + " MHz");
    }

    // Getter method for Memory
    public int getMemory() {
        return memory;
    }

    // Setter method for Memory
    public void setMemory(int memory) {
        this.memory = memory;
    }

    // Getter method for Boost Clock
    public int getBoostClock() {
        return boostClock;
    }

    // Setter method for Boost Clock
    public void setBoostClock(int boostClock) {
        this.boostClock = boostClock;
    }
}
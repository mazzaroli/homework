package homework_30_10_23.components;

// GPU Class
public class GPU extends Component{
    // Fields for the GPU class
    protected int memory;
    protected int boostClock;

    // Constructor for GPU
    public GPU(String model, int memory, int boostClock) {
        super(model);
        this.memory = memory;
        this.boostClock = boostClock;
    }

    // Method to display GPU details
    @Override
    public void displayDetails() {
        System.out.println("GPU Details:");
        System.out.println("Model: " + getModel());
        System.out.println("Video Memory: " + memory + "GB");
        System.out.println("Boost Clock: " + boostClock + " MHz");
    }

    // Getters and setters for Memory
    public int getMemory() {return memory;}
    public void setMemory(int memory) {this.memory = memory;}

    // Getters and setters for Boost Clock
    public int getBoostClock() {return boostClock;}
    public void setBoostClock(int boostClock) {this.boostClock = boostClock;}
}


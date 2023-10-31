package homework_30_10_23.components;

// GPU Class
public class GPU extends Component{
    protected int memory;
    protected int boostClock;

    // Constructor for GPU
    public GPU(String model, int memory, int boostClock) {
        super(model);
        super.model = model;
        this.memory = memory;
        this.boostClock = boostClock;
    }

    @Override
    public void displayDetails() {
        System.out.println("CPU Details:");
        System.out.println("Model: " + super.model);
        System.out.println("Video Memory: " + memory + "GB");
        System.out.println("Boost Clock: " + boostClock + " MHz");
    }

    public int getMemory() {return memory;}

    public void setMemory(int memory) {this.memory = memory;}

    public int getBoostClock() {return boostClock;}

    public void setBoostClock(int boostClock) {this.boostClock = boostClock;}

}

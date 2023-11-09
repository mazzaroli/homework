package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// GPU Class
public class GPU extends Component {
    private static final Logger logger = LogManager.getLogger(GPU.class);

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
        StringBuilder sb = new StringBuilder();
        sb.append("GPU Details:\n");
        sb.append("Model: ").append(getModel()).append("\n");
        sb.append("Video Memory: ").append(getMemory()).append("GB\n");
        sb.append("Boost Clock: ").append(getBoostClock()).append(" MHz");
        logger.info(sb.toString());
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
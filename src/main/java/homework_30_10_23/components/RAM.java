package homework_30_10_23.components;

// RAM Class
public class RAM {
    private int capacity;

    public RAM() {
        // Setting the capacity to 0 in the default constructor
        setCapacity(0);
    }

    // Constructor for RAM with a specified capacity
    public RAM(int capacity) {
        // Setting the capacity based on the provided parameter
        setCapacity(capacity);
    }

    // // Getter and Setter for the capacity of the RAM
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}


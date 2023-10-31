package homework_30_10_23.components;

// Monitor Class
public class Monitor {
    // Field for the Monitor class
    private String type;

    // Constructor for Monitor
    public Monitor(String type) {
        this.type = type;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Monitor{ resolution='" + type + "' }";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        // Calculate hash code based on resolution
        return 31 * type.hashCode();
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Monitor monitor = (Monitor) obj;
        return type.equals(monitor.type);
    }

    // Getter for Monitor type
    public String getType() {
        return type;
    }

    // Setter for Monitor type
    public void setType(String type) {
        this.type = type;
    }
}

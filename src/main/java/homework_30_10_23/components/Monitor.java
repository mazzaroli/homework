package homework_30_10_23.components;

// Monitor Class
public class Monitor {
    private String type;

    // Constructor for Monitor
    public Monitor(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Monitor{ resolution='" + type + "' }";
    }

    @Override
    public int hashCode() {
        // Calculate hash code based on resolution
        return 31 * type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Monitor monitor = (Monitor) obj;
        return type.equals(monitor.type);
    }

    // Getter for Monitor type
    public String getType() { return type; }

    // Setter for Monitor type
    public void setType(String type) { this.type = type; }
}

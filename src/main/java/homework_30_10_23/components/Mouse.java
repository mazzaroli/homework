package homework_30_10_23.components;

// Mouse Class
public class Mouse {
    private String type;

    public Mouse() {
        setType("Default");
    }

    // Constructor for Mouse
    public Mouse(String type) {
        setType(type);
    }

    // Getter and Setter for Mouse type
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

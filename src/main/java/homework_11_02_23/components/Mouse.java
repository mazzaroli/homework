package homework_11_02_23.components;

import homework_11_02_23.interfaces.Clickable;
import homework_11_02_23.interfaces.Configurable;

// Mouse Class
public class Mouse implements Configurable, Clickable {
    private String type;
    private boolean isConfigurable;

    public Mouse() {
        setType("Default");
        setConfigurable(false);
    }

    // Constructor for Mouse
    public Mouse(String type, boolean isConfigurable) {
        setType(type);
        setConfigurable(isConfigurable);
    }

    @Override
    public void configure() {
        if (getIsConfigurable()) {
            System.out.println("Mouse is configurable. Configuring the mouse...");
            // Add configuration logic here
        } else {
            System.out.println("Mouse is not configurable.");
        }
    }

    @Override
    public void click() {
        System.out.println("Mouse does click click click");
    }

    // Getter and Setter for Mouse type
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean getIsConfigurable() {
        return isConfigurable;
    }

    public void setConfigurable(boolean configurable) {
        isConfigurable = configurable;
    }
}

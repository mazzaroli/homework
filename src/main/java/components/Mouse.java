package components;

import exceptions.MouseNotConfigurableException;
import interfaces.Clickable;
import interfaces.Configurable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Mouse Class
public class Mouse implements Configurable, Clickable {
    private static final Logger logger = LogManager.getLogger(Mouse.class);

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
        try {
            if (getIsConfigurable()) {
                logger.info("Mouse is configurable. Configuring the mouse...");
                // Add configuration logic here
            } else {
                logger.warn("Mouse is not configurable.");
                throw new MouseNotConfigurableException("Mouse is not configurable.");
            }
        } catch (MouseNotConfigurableException e) {
            logger.error("Error: " + e.getMessage());
            // You can also handle the exception further or log it here
        }
    }

    @Override
    public void click() {
        logger.info("Mouse does click click click");
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

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
    public Mouse(String type, boolean isConfigurable) throws MouseNotConfigurableException {
        setType(type);
        setConfigurable(isConfigurable);
        if (!isConfigurable) {
            throw new MouseNotConfigurableException("Mouse is not configurable");
        } else {
            logger.info("Mouse is configurable");
        }
    }

    @Override
    public void configure() {
        if (isConfigurable) {
            // Add your configuration logic here
            logger.info("Mouse is configured with default settings");
        } else {
            logger.info("Mouse cannot be configured");
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

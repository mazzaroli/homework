package interfaces;

import exceptions.MouseNotConfigurableException;

// Used in components.Mouse
public interface Configurable {
    void configure() throws MouseNotConfigurableException;
}

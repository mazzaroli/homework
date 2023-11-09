package interfaces;

import exceptions.InvalidKeyboardTypeException;

// Used in components.Keyboard
public interface Connectable {
    void connect() throws InvalidKeyboardTypeException;
}

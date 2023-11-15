package com.solvd.interfaces;

import com.solvd.exceptions.InvalidKeyboardTypeException;

// Used in com.solvd.components.Keyboard
public interface Connectable {
    void connect() throws InvalidKeyboardTypeException;
}

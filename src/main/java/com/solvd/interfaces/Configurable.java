package com.solvd.interfaces;

import com.solvd.exceptions.MouseNotConfigurableException;

// Used in com.solvd.components.Mouse
public interface Configurable {
    void configure() throws MouseNotConfigurableException;
}

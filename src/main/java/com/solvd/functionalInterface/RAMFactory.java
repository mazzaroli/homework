package com.solvd.functionalInterface;

import com.solvd.components.RAM;

// Declaring a functional interface named 'RAMFactory'
@FunctionalInterface
public interface RAMFactory {
    // Abstract method within the functional interface to create a RAM object
    // It takes an 'int' parameter 'capacity' and returns a 'RAM' object
    RAM createRAM(int capacity);
}
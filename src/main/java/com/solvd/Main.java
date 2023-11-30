// Import necessary packages and classes
package com.solvd;

import com.solvd.components.*;
import com.solvd.devices.Laptop;
import com.solvd.enums.ComplexRAMType;
import com.solvd.exceptions.*;
import com.solvd.functionalInterface.RAMFactory;

public class Main {
    public static void main(String[] args) throws NoGhzException, InvalidKeyboardTypeException, MonitorAlreadyOnException, MonitorAlreadyOffException, MouseNotConfigurableException {
        ComplexRAMType ramType = ComplexRAMType.DDR4; // Choose the RAM type you want

        // Creating RAM using the default factory method
        RAM ram = ramType.createRAM();

        // Creating RAM using a custom factory method (passing custom factory implementation) for multiplication
        RAMFactory customFactoryMultiply = customCapacity -> new RAM(customCapacity * 2); // Custom factory that doubles the capacity
        RAM ramCustomMultiply = ramType.createRAM(customFactoryMultiply);

        // Creating RAM using a custom factory method for division
        RAMFactory customFactoryDivide = customCapacity -> new RAM(customCapacity / 2); // Custom factory that divides the capacity by 2
        RAM ramCustomDivide = ramType.createRAM(customFactoryDivide);

        // Creating RAM using a custom factory method for power operation
        RAMFactory customFactoryPower = customCapacity -> new RAM((int) Math.pow(customCapacity, 2)); // Custom factory that squares the capacity
        RAM ramCustomPower = ramType.createRAM(customFactoryPower);

        // Creating a laptop instance
        Laptop macBookM1 = new Laptop(10, "Apple", "MacBook M1", true,
                new CPU("Apple M1", "Apple", 3.2), new GPU("Integrated Apple GPU", 8, 1600),
                ram, new Keyboard("Membrane"), new Monitor("Retina Display", true),
                new Mouse("Trackpad", true));

        // Print the current RAM capacity of macBookM1
        System.out.println("Current RAM Capacity: " + macBookM1.getRam().getCapacity() + "GB");

        // Set the RAM with multiplication custom capacity
        macBookM1.setRam(ramCustomMultiply);

        // Print the RAM capacity after applying multiplication
        System.out.println("RAM Capacity (Multiply): " + macBookM1.getRam().getCapacity() + "GB");

        // Set the RAM with division custom capacity
        macBookM1.setRam(ramCustomDivide);

        // Print the RAM capacity after applying division
        System.out.println("RAM Capacity (Divide): " + macBookM1.getRam().getCapacity() + "GB");

        // Set the RAM with power custom capacity
        macBookM1.setRam(ramCustomPower);

        // Print the RAM capacity after applying power
        System.out.println("RAM Capacity (Power): " + macBookM1.getRam().getCapacity() + "GB");
    }
}
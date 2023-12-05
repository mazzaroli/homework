package com.solvd.enums;

import com.solvd.components.RAM;
import com.solvd.functionalInterface.RAMFactory;

// Enum declaration for ComplexRAMType representing various RAM configurations
public enum ComplexRAMType {
    // Enum constants with associated values of capacity and RAMType
    DDR3(4, RAMType.DDR3),
    DDR4(8, RAMType.DDR4),
    DDR5(16, RAMType.DDR5);

    // Private attributes to store capacity and RAMType for each enum constant
    private final int capacity;
    private final RAMType ramType;

    // Constructor for ComplexRAMType enum, initializing capacity and RAMType
    ComplexRAMType(int capacity, RAMType ramType) {
        this.capacity = capacity;
        this.ramType = ramType;
    }

    // Getter method to retrieve the capacity of the RAM type
    public int getCapacity() {
        return capacity;
    }

    // Getter method to retrieve the RAMType
    public RAMType getRamType() {
        return ramType;
    }

    // Method to create a RAM object with the specified capacity
    public RAM createRAM(){
        return new RAM(this.capacity);
    }

    // Method to create a RAM object using a custom factory implementation
    public RAM createRAM(RAMFactory factory){
        return factory.createRAM(this.capacity);
    }
}
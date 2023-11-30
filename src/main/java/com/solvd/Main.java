package com.solvd;

import com.solvd.GenericFunctions.*;
import com.solvd.components.*;
import com.solvd.devices.Laptop;
import com.solvd.enums.ComplexRAMType;
//import com.solvd.enums.ComputerEnum;
import com.solvd.exceptions.*;
import com.solvd.functionalInterface.RAMFactory;
//import com.solvd.functions.*;

public class Main {
    public static void main(String[] args) throws NoGhzException, InvalidKeyboardTypeException, MonitorAlreadyOnException, MonitorAlreadyOffException, MouseNotConfigurableException {
        ComplexRAMType ramType = ComplexRAMType.DDR4; // Choose the RAM type you want
        // Creating RAM using the default factory method
        RAM ram = ramType.createRAM();

        // Outputting the RAM capacity
        System.out.println("RAM Capacity: " + ram.getCapacity());

        // Creating RAM using a custom factory method (passing custom factory implementation)
        RAMFactory customFactory = customCapacity -> new RAM(customCapacity * 2); // Custom factory that doubles the capacity
        RAM ramCustom = ramType.createRAM(customFactory);

        // Outputting the custom RAM capacity
        System.out.println("Custom RAM Capacity: " + ramCustom.getCapacity());

        Laptop macBookM1 = new Laptop(10, "Apple", "MacBook M1", true,
                new CPU("Apple M1", "Apple", 3.2), new GPU("Integrated Apple GPU", 8, 1600),
                ram, new Keyboard("Membrane"), new Monitor("Retina Display", true),
                new Mouse("Trackpad", true));

        macBookM1.printInfo();

        macBookM1.setRam(ramCustom);

        macBookM1.printInfo();

        /*
        System.out.println("// Create 5 complex Enums (with fields, methods, blocks).");
        for (ComputerEnum computer : ComputerEnum.values()) {
            System.out.println("Brand: " + computer.getBrand());
            System.out.println("Model: " + computer.getModel());
            System.out.println();
        }

        //-----------------------------------------------------------------------------
        System.out.println("// Use at least 5 lambda functions from the java.util.function package.");
        System.out.println("Executing PredicateExample:");
        PredicateExample.main(args);

        System.out.println("\nExecuting FunctionExample:");
        FunctionExample.main(args);

        System.out.println("\nExecuting ConsumerExample:");
        ConsumerExample.main(args);

        System.out.println("\nExecuting SupplierExample:");
        SupplierExample.main(args);

        System.out.println("\nExecuting BiFunctionExample:");
        BiFunctionExample.main(args);

        //-----------------------------------------------------------------------------
        System.out.println("\n// Create 3 custom Lambda functions with generics.");
        System.out.println("Executing GenericConsumerExample:");
        GenericConsumerExample.main(new String[]{});

        System.out.println("\nExecuting GenericFunctionExample:");
        GenericFunctionExample.main(new String[]{});

        System.out.println("\nExecuting GenericPredicateExample:");
        GenericPredicateExample.main(new String[]{}); */
    }
}
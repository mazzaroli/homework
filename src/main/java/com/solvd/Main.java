package com.solvd;

import com.solvd.GenericFunctions.*;
import com.solvd.enums.ComputerEnum;
import com.solvd.functions.*;

public class Main {
    public static void main(String[] args) {
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
        GenericPredicateExample.main(new String[]{});
    }
}
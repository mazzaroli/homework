package com.solvd;

import com.solvd.collections.ComputerInventoryManager;
import com.solvd.components.*;
import com.solvd.computer.Computer;
import com.solvd.devices.Laptop;
import com.solvd.reflection.ReflectionHandler;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Laptop macBookM1 = new Laptop(10, "Apple", "Macbook M1", true,
                new CPU("Apple M1", "Apple", 3.2), new GPU("Integrated Apple GPU", 8, 1600),
                new RAM(8), new Keyboard("Membrane"), new Monitor("Retina Display", true),
                new Mouse("Trackpad", true));

        Laptop macBookM2 = new Laptop(11, "Apple", "Macbook M2", true,
                new CPU("Apple M2", "Apple", 3.5), new GPU("Integrated Apple Pro GPU", 16, 2000),
                new RAM(16), new Keyboard("Membrane"), new Monitor("Pro Retina Display", true),
                new Mouse("Magic Trackpad", true));

        String nisseiAsuncion = "Nissei Asunción: Avenida España 1261";

        //##############################################################################

        // Using Java Reflection to work with ComputerInventoryManager class
        Class<ComputerInventoryManager> ComputerIMClass = ComputerInventoryManager.class;
        ComputerInventoryManager inventoryManager = new ComputerInventoryManager();

        //------------------------------------------------------------

        // Invoking a method from ReflectionHandler class to inspect methods of ComputerInventoryManager
        ReflectionHandler.inspectMethods(ComputerInventoryManager.class);

        //------------------------------------------------------------

        // Using Reflection to access and invoke the 'addToStock' method of ComputerInventoryManager
        Method addToStockMethod = ComputerIMClass.getDeclaredMethod("addToStock", Computer.class, String.class, int.class);
        addToStockMethod.setAccessible(true);

        addToStockMethod.invoke(inventoryManager, macBookM1, nisseiAsuncion, 10);
        addToStockMethod.invoke(inventoryManager, macBookM2, nisseiAsuncion, 100);

        //------------------------------------------------------------

        // Using Reflection to access and invoke the 'displayInventoryByBrandAndModel' method of ComputerInventoryManager
        Method displayInventoryMethod = ComputerIMClass.getDeclaredMethod("displayInventoryByBrandAndModel", String.class);
        displayInventoryMethod.setAccessible(true);
        displayInventoryMethod.invoke(inventoryManager, "Apple");

    }
}
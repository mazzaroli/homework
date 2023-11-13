// Importing necessary components and exceptions
import collections.ComputerInventoryManager;
import components.*;
import devices.Laptop;
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Main Class
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NoGhzException, InvalidKeyboardTypeException,
            MonitorAlreadyOnException, MonitorAlreadyOffException, MouseNotConfigurableException {
        // Create an instance of ComputerInventoryManager
        ComputerInventoryManager inventoryManager = new ComputerInventoryManager();

        // Additional laptops for each brand
        Laptop macBookM1 = new Laptop(10, "Apple", "MacBook M1", true,
                new CPU("Apple M1", "Apple", 3.2), new GPU("Integrated Apple GPU", 8, 1600),
                new RAM(8), new Keyboard("Membrane"), new Monitor("Retina Display", true),
                new Mouse("Trackpad", true));

        Laptop macBookM2 = new Laptop(11, "Apple", "MacBook M40", true,
                new CPU("Apple M2", "Apple", 3.5), new GPU("Integrated Apple Pro GPU", 16, 2000),
                new RAM(16), new Keyboard("Membrane"), new Monitor("Pro Retina Display", true),
                new Mouse("Magic Trackpad", true));

        // Addresses of branches
        String nisseiAsuncion = "Nissei Asunción: Avenida España 1261";
        String ryrChaco = "RyR Computación: Santiago del Estero 414";

        // Add to stock
        inventoryManager.addToStock(macBookM1, nisseiAsuncion, 10);
        inventoryManager.addToStock(macBookM2, nisseiAsuncion, 20);

        // Display inventory by branch
        logger.info("Inventory by Branch:");
        inventoryManager.displayInventoryByBranch();

        // Update stock
        inventoryManager.updateStock(macBookM1, nisseiAsuncion, 5);
        logger.info("Stock of MacBook M1 updated in Nissei Asunción.");

        // Display inventory by branch after update
        logger.info("Updated Inventory by Branch:");
        inventoryManager.displayInventoryByBranch();

        // Display inventory by brand and model
        logger.info("Inventory by Brand and Model (Apple):");
        inventoryManager.displayInventoryByBrandAndModel("Apple");

        // Get stock
        int stock = inventoryManager.getStock(macBookM1, nisseiAsuncion);
        logger.info("Stock of MacBook M1 in Nissei Asunción: " + stock);

        // Delete from stock
        inventoryManager.deleteFromStock(macBookM1, nisseiAsuncion, "All");
        logger.info("MacBook M1 deleted from Nissei Asunción.");

        // Display inventory by branch after deletion
        logger.info("Inventory by Branch after Deletion:");
        inventoryManager.displayInventoryByBranch();
    }
}
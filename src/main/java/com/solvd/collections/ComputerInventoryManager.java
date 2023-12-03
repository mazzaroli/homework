package com.solvd.collections;

import java.util.*;
import java.util.stream.Collectors;

import com.solvd.computer.Computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Class for managing com.solvd.computer inventory
public class ComputerInventoryManager {

    // Logger for logging messages
    private static final Logger logger = LogManager.getLogger(com.solvd.collections.ComputerInventoryManager.class);

    // Data structures for managing the inventory
    private final Map<String, Map<Computer, Integer>> inventoryByBranch = new HashMap<>();
    private final List<Computer> computers = new ArrayList<>();
    private final Set<String> brands = new HashSet<>();
    private final Map<String, List<Computer>> computersByBrand = new HashMap<>();
    private final Map<String, Integer> stockQuantities = new HashMap<>();
    private final Map<String, Set<Computer>> uniqueComputersByBranch = new HashMap<>();

    // Constructor to initialize data structures
    public ComputerInventoryManager() {
        // Initialize data structures
    }

    /**
     * Method to add computers to the inventory.
     * Updates various com.solvd.collections to reflect the addition of a com.solvd.computer to the stock.
     * Logs information about the addition.
     */
    public void addToStock(Computer computer, String branch, int quantity) {
        if (computer == null || branch == null || branch.isEmpty() || quantity <= 0) {
            // Log an error if parameters are invalid
            logger.error("Invalid parameters. Cannot add the com.solvd.computer to the inventory.");
            return;
        }

        // Update the 'computers' collection with the new com.solvd.computer
        computers.add(computer);

        // Update the 'brands' collection with the brand of the new com.solvd.computer
        brands.add(computer.getBrand());

        // Update the 'computersByBrand' collection, adding the com.solvd.computer to the list of computers for its brand
        computersByBrand.computeIfAbsent(computer.getBrand(), k -> new ArrayList<>()).add(computer);

        // Update the 'stockQuantities' collection, incrementing the quantity for the brand
        stockQuantities.put(computer.getBrand(), stockQuantities.getOrDefault(computer.getBrand(), 0) + quantity);

        // Update the 'uniqueComputersByBranch' collection, adding the com.solvd.computer to the set for the branch
        uniqueComputersByBranch.computeIfAbsent(branch, k -> new HashSet<>()).add(computer);

        // Update the 'inventoryByBranch' collection, adding the com.solvd.computer and its quantity to the branch's inventory
        inventoryByBranch.computeIfAbsent(branch, k -> new HashMap<>()).put(computer, quantity);

        // Log information about the addition of the com.solvd.computer to the stock
        logger.info(quantity + " " + computer.getBrand() + " " + computer.getModel() + " added to branch " + branch);
    }

    /**
     * Method to update the stock of a com.solvd.computer in a specific branch.
     * Updates the branch inventory, stock quantities, and logs information about the update.
     */
    public void updateStock(Computer computer, String branch, int newQuantity) {
        if (computer == null || branch == null || branch.isEmpty() || newQuantity < 0) {
            // Log an error if parameters are invalid
            logger.error("Invalid parameters. Cannot update the stock.");
            return;
        }

        // Get the inventory of the specified branch
        Map<Computer, Integer> branchInventory = inventoryByBranch.get(branch);

        // Check if the branch inventory contains the specified com.solvd.computer
        if (branchInventory != null && branchInventory.containsKey(computer)) {
            // Get the old quantity from the branch inventory
            int oldQuantity = branchInventory.get(computer);

            // Update the quantity in the branch inventory with the new quantity
            branchInventory.put(computer, newQuantity);

            // Update the 'stockQuantities' collection, adjusting the quantity for the com.solvd.computer's brand
            stockQuantities.put(computer.getBrand(), stockQuantities.getOrDefault(computer.getBrand(), 0) - oldQuantity + newQuantity);

            // Log information about the stock update
            logger.info("Stock updated for com.solvd.computer {} {} in branch {}. New quantity: {}", computer.getBrand(),
                    computer.getModel(), branch, newQuantity);
        } else {
            // Log an error if the com.solvd.computer is not found in the branch inventory
            logger.error("Computer {} {} does not exist in branch {}", computer.getBrand(), computer.getModel(), branch);
        }
    }

    /**
     * Method to delete a specified quantity of a com.solvd.computer from the stock.
     * Validates parameters, updates branch inventory, and logs information about the removal.
     */
    public void deleteFromStock(Computer computer, String branch, int quantity) {
        // Validate parameters to ensure they are not null or empty
        if (validateParameters(computer, branch)) {
            // Get the inventory of the specified branch
            Map<Computer, Integer> branchInventory = inventoryByBranch.get(branch);

            // Check if the branch inventory contains the specified com.solvd.computer
            if (branchInventory != null && branchInventory.containsKey(computer)) {
                // Get the current stock of the specified com.solvd.computer in the branch
                int currentStock = branchInventory.get(computer);

                // Calculate the new stock after removing the specified quantity, ensuring it's not negative
                int newStock = Math.max(0, currentStock - quantity);

                // Update the branch inventory with the new stock
                branchInventory.put(computer, newStock);

                // Log information about the removal of the com.solvd.computer from the branch
                logger.info("Computer {} {} removed from branch {}. Quantity removed: {}. Remaining stock: {}",
                        computer.getBrand(), computer.getModel(), branch, quantity, newStock);
            } else {
                // Log an error if the com.solvd.computer is not found in the branch inventory
                logger.error("Computer {} {} does not exist in branch {}", computer.getBrand(), computer.getModel(), branch);
            }
        } else {
            // Log an error if the parameters are invalid
            logger.error("Cannot delete the com.solvd.computer from the inventory. Check the parameters.");
        }
    }

    /**
     * Method to delete a com.solvd.computer from the stock based on the specified option.
     * Validates parameters, updates branch inventory, and logs information about the removal.
     */
    public void deleteFromStock(Computer computer, String branch, String option) {
        // Validate parameters to ensure they are not null or empty
        if (validateParameters(computer, branch)) {
            // Get the inventory of the specified branch
            Map<Computer, Integer> branchInventory = inventoryByBranch.get(branch);

            // Check if the branch inventory contains the specified com.solvd.computer
            if (branchInventory != null && branchInventory.containsKey(computer)) {
                // Check the specified option to determine the deletion strategy
                if ("all".equalsIgnoreCase(option)) {
                    // Remove the entire stock of the specified com.solvd.computer from the branch
                    branchInventory.remove(computer);

                    // Log information about the removal of the entire stock of the com.solvd.computer from the branch
                    logger.info("Computer {} {} removed from branch {}. Entire stock removed. Remaining stock: 0",
                            computer.getBrand(), computer.getModel(), branch);
                } else {
                    // Log an error if the specified option is invalid
                    logger.error("Invalid option. Specify 'all' to delete all stock.");
                }
            } else {
                // Log an error if the com.solvd.computer is not found in the branch inventory
                logger.error("Computer {} {} does not exist in branch {}", computer.getBrand(), computer.getModel(), branch);
            }
        } else {
            // Log an error if the parameters are invalid
            logger.error("Cannot delete the com.solvd.computer from the inventory. Check the parameters.");
        }
    }

    /**
     * Method to validate parameters before performing operations.
     * Returns true if the com.solvd.computer is not null, and branch is not null or empty; otherwise, returns false.
     */
    private boolean validateParameters(Computer computer, String branch) {
        return computer != null && branch != null && !branch.isEmpty();
    }

    /**
     * Method to retrieve the stock of a specific com.solvd.computer in a given branch.
     * Returns the stock quantity if the com.solvd.computer is found, logs an error otherwise.
     */
    public int getStock(Computer computer, String branch) {
        // Check if the com.solvd.computer object and branch string are not null or empty
        if (computer != null && branch != null && !branch.isEmpty()) {
            // Get the inventory of the specified branch
            Map<Computer, Integer> branchInventory = inventoryByBranch.get(branch);

            // Check if the branch inventory contains the specified com.solvd.computer
            if (branchInventory != null && branchInventory.containsKey(computer)) {
                // Retrieve the stock quantity of the specified com.solvd.computer in the branch
                int stock = branchInventory.get(computer);

                // Log information about the stock retrieval
                logger.info("Stock of {} {} in {}: {}", computer.getBrand(), computer.getModel(), branch, stock);

                // Return the stock quantity
                return stock;
            } else {
                // Log an error if the com.solvd.computer is not found in the branch inventory
                logger.error("Computer {} {} does not exist in branch {}", computer.getBrand(), computer.getModel(), branch);

                // Return 0 as the com.solvd.computer is not found
                return 0;
            }
        } else {
            // Log an error if the parameters are invalid
            logger.error("Cannot get the stock. Check the parameters.");

            // Return 0 as the parameters are invalid
            return 0;
        }
    }

    /**
     * Method to display the inventory of computers grouped by branch.
     * Logs information about the inventory for each branch.
     */
    public void displayInventoryByBranch() {
        // Log empty lines and start message for visual separation
        logger.info("");
        logger.info("Starting displayInventoryByBranch...");
        logger.info("");

        // Check if the inventory by branch is empty
        if (inventoryByBranch.isEmpty()) {
            logger.info("Inventory by branch is empty.");
            return;
        }

        // Iterate through each entry in the inventory by branch
        inventoryByBranch.entrySet().forEach(entry -> {
            // Get branch and its inventory
            String branch = entry.getKey();
            Map<Computer, Integer> branchInventory = entry.getValue();

            // Log header for inventory of the current branch
            logger.info("Inventory of branch {}:", branch);

            // Stream through branch inventory entries, sorted by computer brand, and log information
            branchInventory.entrySet().stream()
                    .sorted(Comparator.comparing(entry2 -> entry2.getKey().getBrand()))
                    .forEach(computerEntry -> {
                        Computer computer = computerEntry.getKey();
                        int units = computerEntry.getValue();
                        logger.info("-> {} units of computer brand {} and model {}",
                                units, computer.getBrand(), computer.getModel());
                    });

            // Log blank line after displaying the inventory of the current branch
            logger.info("");
        });

        // Log message indicating completion of the method
        logger.info("Finished displayInventoryByBranch.");
    }


    /**
     * Method to display the inventory of computers for a specific brand and count models.
     * Logs information about the count of each model for the specified brand.
     */

    /**
     * Method to display the inventory of computers for a specific brand and count models.
     * Logs information about the count of each model for the specified brand.
     *
     * @param targetBrand The brand for which the inventory and model count are displayed. For example "Apple"
     */
    public void displayInventoryByBrandAndModel(String targetBrand) {
        // Logs to indicate the start of the method execution
        logger.info("");
        logger.info("Starting displayInventoryByBrandAndModel for brand {}...", targetBrand);
        logger.info("");

        // Checks if the list of computers is empty
        if (computers.isEmpty()) {
            logger.info("Computer list is empty.");
            return;
        }

        // Checks if the specified brand exists in the inventory
        if (!brands.contains(targetBrand)) {
            logger.info("Brand {} is not present in the inventory.", targetBrand);
            return;
        }

        // Logs the header for the inventory of computers for the specified brand
        logger.info("Inventory of computers for brand {}:", targetBrand);

        // Retrieves the list of computers for the specified brand using an Optional
        Optional.ofNullable(computersByBrand.get(targetBrand))
                // If the list is present, stream through each computer and corresponding inventory
                .ifPresent(computersOfBrand -> computersOfBrand.stream()
                        .flatMap(computer -> inventoryByBranch.values().stream()
                                // Filters the branch inventory to get entries containing the computer
                                .filter(branchInventory -> branchInventory.containsKey(computer))
                                // Maps to create entries of model and its count for the computer
                                .map(branchInventory -> Map.entry(computer.getModel(), branchInventory.get(computer))))
                        // Collects and groups the entries by model while summing up the counts
                        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                        // Streams through the grouped entries, sorts by model, and logs the count information
                        .entrySet().stream()
                        .sorted(Comparator.comparing(Map.Entry::getKey))
                        .forEach(entry -> logger.info("-> {} units of model {}", entry.getValue(), entry.getKey()))
                );
    }
}
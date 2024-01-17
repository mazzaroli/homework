package com.solvd.database.controller;

import com.solvd.Main;
import com.solvd.database.model.Ram;
import com.solvd.database.strategy.RamSortingStrategy;
import com.solvd.database.view.RamView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RamController {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private RamView ramView;
    private List<Ram> ramList;
    private RamSortingStrategy sortingStrategy;

    public RamController(RamView ramView, List<Ram> ramList) {
        this.ramView = ramView;
        this.ramList = ramList;
    }

    public void displayRamDetails(int ramId) {
        Ram selectedRam = getRamById(ramId);
        ramView.displayRamDetails(selectedRam);
    }

    public void displayAllRam() {
        ramView.displayRamList(ramList);
    }

    private Ram getRamById(int ramId) {
        // Implement logic to retrieve RAM by ID from the list or database
        // In this example, searching directly in the list
        return ramList.stream()
                .filter(ram -> ram.getId().equals(ramId))
                .findFirst()
                .orElse(null);
    }

    public void setSortingStrategy(RamSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void displaySortedRam() {
        if (sortingStrategy != null) {
            List<Ram> sortedRams = sortingStrategy.sort(ramList);
            ramView.displayRamList(sortedRams);
        } else {
            // Handle error or provide a default message
            LOGGER.error("Sorting strategy not set");
        }
    }
}

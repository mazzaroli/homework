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
        // Implementar lógica para obtener la RAM por ID desde la lista o la base de datos
        // En este ejemplo, se buscará en la lista directamente
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
            // Manejo de error o mensaje predeterminado
            LOGGER.error("Sorting strategy not set");
        }
    }
}
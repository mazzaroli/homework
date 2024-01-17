package com.solvd;

import com.solvd.database.controller.RamController;
import com.solvd.database.dao.*;
import com.solvd.database.model.Ram;
import com.solvd.database.strategy.SortByCapacity;
import com.solvd.database.util.dao.DAOFactoryGenerator;
import com.solvd.database.view.ConsoleRamView;
import com.solvd.database.view.RamView;
import com.solvd.enums.FactoryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.enums.DAOType.RAM;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // =================== Proxy Pattern ===================
        // Create an instance of the desired concrete factory (e.g., JDBC)
        IRamDAO ramDAO = (IRamDAO) DAOFactoryGenerator.createFactory(FactoryType.JDBC).getFactory(RAM);
        System.out.println(ramDAO.getEntities());

        // =================== Builder Pattern ===================
        Ram ram1 = new Ram.RamBuilder()
                .id(1)
                .capacity(64)
                .computerId(123)
                .build();

        Ram ram2 = new Ram.RamBuilder()
                .id(2)
                .capacity(8)
                .computerId(456)
                .build();

        Ram ram3 = new Ram.RamBuilder()
                .id(3)
                .capacity(777)
                .computerId(789)
                .build();

        // RAM listener
        Ram.RamListener ramListener = new Ram.RamListener() {
            @Override
            public void onRamCreated(Ram ram) {
                System.out.println("Event: New RAM instance created - " + ram);
            }
        };

        ramListener.onRamCreated(ram1);

        // =================== MVC Pattern ===================
        List<Ram> ramList = new ArrayList<>();
        ramList.add(ram1);
        ramList.add(ram2);
        ramList.add(ram3);

        RamView ramView = new ConsoleRamView(); // You can implement different views (console, GUI, web)
        RamController ramController = new RamController(ramView, ramList);

        // Display details of a RAM by ID
        ramController.displayRamDetails(2);

        // Display all RAMs
        ramController.displayAllRam();

        // Use a specific sorting strategy (can be changed dynamically)
        ramController.setSortingStrategy(new SortByCapacity());

        // Display Rams sorted by capacity
        System.out.println("Hello");
        ramController.displaySortedRam();
    }
}
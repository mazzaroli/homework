package com.solvd.database.view;

import com.solvd.database.model.Ram;

import java.util.List;

public class ConsoleRamView implements RamView {
    @Override
    public void displayRamDetails(Ram ram) {
        System.out.println("RAM Details: " + ram);
    }

    @Override
    public void displayRamList(List<Ram> ramList) {
        System.out.println("All RAMs:");
        for (Ram ram : ramList) {
            System.out.println(ram);
        }
    }
}
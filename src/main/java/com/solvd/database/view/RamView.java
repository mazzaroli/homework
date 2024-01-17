package com.solvd.database.view;

import com.solvd.database.model.Ram;

import java.util.List;

public interface RamView {
    void displayRamDetails(Ram ram);

    void displayRamList(List<Ram> ramList);
}
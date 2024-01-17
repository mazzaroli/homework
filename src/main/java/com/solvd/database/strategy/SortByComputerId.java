package com.solvd.database.strategy;

import com.solvd.database.model.Ram;

import java.util.Comparator;
import java.util.List;

public class SortByComputerId implements RamSortingStrategy {
    @Override
    public List<Ram> sort(List<Ram> ramList) {
        ramList.sort(Comparator.comparingInt(Ram::getComputer_computer_id));
        return ramList;
    }
}
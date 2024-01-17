package com.solvd.database.strategy;

import com.solvd.database.model.Ram;

import java.util.Comparator;
import java.util.List;

public class SortByCapacity implements RamSortingStrategy {
    @Override
    public List<Ram> sort(List<Ram> ramList) {
        ramList.sort(Comparator.comparingInt(Ram::getCapacity));
        return ramList;
    }
}
package com.solvd.database.strategy;

import com.solvd.database.model.Ram;

import java.util.List;

public interface RamSortingStrategy {
    List<Ram> sort(List<Ram> ramList);
}
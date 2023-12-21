package com.solvd.database.dao;

import com.solvd.database.model.Cpu;

import java.util.List;

public interface ICpuDAO extends IBaseDao{
    Cpu getEntityById(int id);

    void insertEntity(Cpu t);

    void updateEntity(Cpu t);

    void removeEntity(Cpu t);

    List<Cpu> getEntities();
}
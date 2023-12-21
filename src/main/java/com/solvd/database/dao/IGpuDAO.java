package com.solvd.database.dao;

import com.solvd.database.model.Gpu;

import java.sql.SQLException;
import java.util.List;

public interface IGpuDAO extends IBaseDao{

    Gpu getEntityById(int id) throws SQLException;

    void insertEntity(Gpu t);

    void updateEntity(Gpu t);

    void removeEntity(Gpu t);

    List<Gpu> getEntities();
}
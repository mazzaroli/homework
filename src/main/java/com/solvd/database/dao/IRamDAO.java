package com.solvd.database.dao;

import com.solvd.database.model.Ram;

import java.util.List;

public interface IRamDAO extends IBaseDao{
    Ram getEntityById(int id);

    void insertEntity(Ram t);

    void updateEntity(Ram t);

    void removeEntity(Ram t);

    List<Ram> getEntities();
}
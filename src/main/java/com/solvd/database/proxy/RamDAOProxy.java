package com.solvd.database.proxy;

import com.solvd.database.dao.IRamDAO;
import com.solvd.database.model.Ram;
import com.solvd.database.dao.jbdc.RamDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RamDAOProxy implements IRamDAO {
    private RamDAO realRamDAO = new RamDAO();
    private static final Logger LOGGER = LogManager.getLogger(RamDAOProxy.class);

    @Override
    public Ram getEntityById(int id) {
        LOGGER.info("Proxy: Performing additional operations before retrieving Ram by ID");
        System.out.println("Proxy");
        Ram ram = realRamDAO.getEntityById(id);
        LOGGER.info("Proxy: Performing additional operations after retrieving Ram by ID");
        return ram;
    }

    @Override
    public void insertEntity(Ram ram) {
        LOGGER.info("Proxy: Performing additional operations before inserting Ram");
        realRamDAO.insertEntity(ram);
        LOGGER.info("Proxy: Performing additional operations after inserting Ram");
    }

    @Override
    public void updateEntity(Ram ram) {
        LOGGER.info("Proxy: Performing additional operations before updating Ram");
        realRamDAO.updateEntity(ram);
        LOGGER.info("Proxy: Performing additional operations after updating Ram");
    }

    @Override
    public void removeEntity(Ram ram) {
        LOGGER.info("Proxy: Performing additional operations before deleting Ram");
        realRamDAO.removeEntity(ram);
        LOGGER.info("Proxy: Performing additional operations after deleting Ram");
    }

    @Override
    public List<Ram> getEntities() {
        LOGGER.info("Proxy: Performing additional operations before retrieving all Ram entities");
        List<Ram> ramList = realRamDAO.getEntities();
        LOGGER.info("Proxy: Performing additional operations after retrieving all Ram entities");
        return ramList;
    }

    @Override
    public void insertEntity(Object o) {
    }

    @Override
    public void updateEntity(Object o, int i) {

    }

    @Override
    public void removeEntity(Object o) {

    }
}
package com.solvd;

import com.solvd.database.dao.*;
import com.solvd.database.model.*;
import com.solvd.database.util.DAOFactoryGenerator;
import com.solvd.enums.FactoryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

import static com.solvd.enums.DAOType.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        IGpuDAO gpuDAO = (IGpuDAO) DAOFactoryGenerator.createFactory(FactoryType.MYBATIS).getFactory(GPU);
        IRamDAO ramDAO = (IRamDAO) DAOFactoryGenerator.createFactory(FactoryType.MYBATIS).getFactory(RAM);
        ICpuDAO cpuDAO = (ICpuDAO) DAOFactoryGenerator.createFactory(FactoryType.MYBATIS).getFactory(CPU);

        // ##############################
        // Create Operations
        // ##############################

        // Create and insert a new GPU into the database
        Gpu gpuToAdd = new Gpu();
        gpuToAdd.setMemory(8);
        gpuToAdd.setBoostClock(1800);
        gpuToAdd.setPrice(399.99);
        gpuToAdd.setComponent_id(2);
        gpuToAdd.setComputer_computer_id(2);
        gpuDAO.insertEntity(gpuToAdd);

        // Create and insert a new RAM into the database
        Ram ramToAdd = new Ram();
        ramToAdd.setCapacity(777);
        ramToAdd.setComputer_computer_id(2);
        ramDAO.insertEntity(ramToAdd);

        // Create and insert a new CPU into the database
        Cpu cpuToAdd = new Cpu();
        cpuToAdd.setManufacturer("Intel");
        cpuToAdd.setSpeed(7.7);
        cpuToAdd.setComponent_id(2);
        cpuToAdd.setComputer_computer_id(2);
        cpuDAO.insertEntity(cpuToAdd);

        // ##############################
        // Read Operations
        // ##############################

        // Read a specific GPU by its ID
        int gpuIdToRead = 15; // Assuming 1 is the ID of the GPU you want to read
        Gpu gpuRead = gpuDAO.getEntityById(gpuIdToRead);
        System.out.println("Data of the read GPU: " + gpuRead);

        // Read a specific RAM by its ID
        int ramIdToRead = 2; // Assuming 2 is the ID of the RAM you want to read
        Ram ramRead = ramDAO.getEntityById(ramIdToRead);
        System.out.println("Data of the read RAM: " + ramRead);

        // Read a specific CPU by its ID
        int cpuIdToRead = 2; // Assuming 2 is the ID of the CPU you want to read
        Cpu cpuRead = cpuDAO.getEntityById(cpuIdToRead);
        System.out.println("Data of the read CPU: " + cpuRead);

        // ##############################
        // Update Operations
        // ##############################

        // Update an existing GPU
        Gpu gpuToUpdate = gpuDAO.getEntityById(15);
        if (gpuToUpdate != null) {
            gpuToUpdate.setPrice(999.99); // Update price
            gpuDAO.updateEntity(gpuToUpdate);
        } else {
            System.out.println("Data of the read GPU: " + gpuRead);
        }

        // Update an existing RAM
        Ram ramToUpdate = ramDAO.getEntityById(2);
        if (ramToUpdate != null) {
            ramToUpdate.setCapacity(99); // Update capacity
            ramToUpdate.setComputer_computer_id(1);
            ramDAO.updateEntity(ramToUpdate);
        } else {
            System.out.println("Data of the read RAM: " + ramRead);
        }

        // Update an existing CPU
        Cpu cpuToUpdate = cpuDAO.getEntityById(1);
        if (cpuToUpdate != null) {
            cpuToUpdate.setSpeed(99.0); // Update speed
            cpuDAO.updateEntity(cpuToUpdate);
        } else {
            System.out.println("Data of the read CPU: " + cpuRead);
        }

        // ##############################
        // Delete Operations
        // ##############################

        // Delete a GPU by its ID
        Gpu gpuIdToDelete = gpuDAO.getEntityById(2); // Assuming 2 is the ID of the GPU you want to delete
        gpuDAO.removeEntity(gpuIdToDelete);
        List<Gpu> gpus = gpuDAO.getEntities();
        gpus.forEach(LOGGER::error);

        // Delete a RAM by its ID
        ramDAO.removeEntity(ramDAO.getEntityById(6));
        List<Ram> rams = ramDAO.getEntities();
        rams.forEach(LOGGER::error);

        // Delete a CPU by its ID
        cpuDAO.removeEntity(cpuDAO.getEntityById(6));
        List<Cpu> cpus = cpuDAO.getEntities();
        cpus.forEach(LOGGER::error);
    }
}
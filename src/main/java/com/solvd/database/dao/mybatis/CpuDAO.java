package com.solvd.database.dao.mybatis;

import com.solvd.database.util.ConnectionPool;
import com.solvd.database.dao.ICpuDAO;
import com.solvd.database.model.Cpu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CpuDAO implements ICpuDAO {
    private static final Logger logger = LogManager.getLogger(CpuDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    /** Retrieves a Cpu entity from the database based on its ID.
     * @param id The ID of the Cpu entity to retrieve.
     * @return A Cpu object retrieved from the database.
     */
    @Override
    public Cpu getEntityById(int id) {
        Connection connection = connectionPool.retrieve();
        Cpu cpu = new Cpu();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from cpu where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                cpu.setId(resultSet.getInt("id"));
                cpu.setManufacturer(resultSet.getString("manufacturer"));
                cpu.setSpeed(resultSet.getDouble("speed"));
                cpu.setComponent_id(resultSet.getInt("Component_id"));
                cpu.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Cpu entity by ID: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            closeAll(preparedStatement, resultSet);
        }

        return cpu;
    }

    /** Inserts a Cpu entity into the database.
     * @param t The Cpu object to insert.
     */
    @Override
    public void insertEntity(Cpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO cpu (manufacturer, speed, Component_id, Computer_computer_id) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, t.getManufacturer());
            preparedStatement.setDouble(2, t.getSpeed());
            preparedStatement.setInt(3, t.getComponent_id());
            preparedStatement.setInt(4, t.getComputer_computer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting Cpu entity: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Error closing PreparedStatement: {}", e.getMessage());
            }
        }
    }

    /** Updates a Cpu entity in the database.
     * @param t The Cpu object to update.
     */
    @Override
    public void updateEntity(Cpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE cpu SET manufacturer=?, speed=?, Component_id=?, Computer_computer_id=? WHERE id=?");
            preparedStatement.setString(1, t.getManufacturer());
            preparedStatement.setDouble(2, t.getSpeed());
            preparedStatement.setInt(3, t.getComponent_id());
            preparedStatement.setInt(4, t.getComputer_computer_id());
            preparedStatement.setInt(5, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating Cpu entity: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Error closing PreparedStatement: {}", e.getMessage());
            }
        }
    }

    /** Removes a Cpu entity from the database.
     * @param t The Cpu object to remove.
     */
    @Override
    public void removeEntity(Cpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM cpu WHERE id=?");
            preparedStatement.setInt(1, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting Cpu entity: {}", e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Error closing PreparedStatement: {}", e.getMessage());
            }
            connectionPool.putback(connection);
        }
    }

    /** Retrieves all Cpu entities from the database.
     * @return A list of Cpu objects retrieved from the database.
     */
    @Override
    public List<Cpu> getEntities() {
        List<Cpu> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from cpu");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Cpu cpu = new Cpu();
                cpu.setId(resultSet.getInt("id"));
                cpu.setManufacturer(resultSet.getString("manufacturer"));
                cpu.setSpeed(resultSet.getDouble("speed"));
                cpu.setComponent_id(resultSet.getInt("Component_id"));
                cpu.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
                list.add(cpu);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Cpu entities: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            closeAll(preparedStatement, resultSet);
        }
        return list;
    }

    private void closeAll(PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("Error closing ResultSet: {}", e.getMessage());
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Error closing PreparedStatement: {}", e.getMessage());
            }
        }
    }

    // Additional methods overridden from ICpuDAO interface, left blank as not implemented in this class.
    @Override
    public void insertEntity(Object o) {}

    @Override
    public void updateEntity(Object o, int i) {}

    @Override
    public void removeEntity(Object o) {}
}
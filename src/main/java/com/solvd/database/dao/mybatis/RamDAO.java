package com.solvd.database.dao.mybatis;

import com.solvd.database.util.ConnectionPool;
import com.solvd.database.dao.IRamDAO;
import com.solvd.database.model.Ram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RamDAO implements IRamDAO {
    private static Logger logger = LogManager.getLogger(RamDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(RamDAO.class);

    /** Retrieves a Ram entity from the database based on its ID.
     * @param id The ID of the Ram entity to retrieve.
     * @return A Ram object retrieved from the database.
     */
    @Override
    public Ram getEntityById(int id) {
        Connection connection = connectionPool.retrieve();
        Ram ram = new Ram();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from ram where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                ram.setId(resultSet.getInt("id"));
                ram.setCapacity(resultSet.getInt("capacity"));
                ram.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Ram entity by ID: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            closeAll(preparedStatement, resultSet);
        }

        return ram;
    }

    /** Inserts a Ram entity into the database.
     * @param t The Ram object to insert.
     */
    @Override
    public void insertEntity(Ram t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ram (capacity, Computer_computer_id) VALUES (?, ?)");
            preparedStatement.setInt(1, t.getCapacity());
            preparedStatement.setInt(2, t.getComputer_computer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting Ram entity: {}", e.getMessage());
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

    /** Updates a Ram entity in the database.
     * @param t The Ram object to update.
     */
    @Override
    public void updateEntity(Ram t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE ram SET capacity=?, Computer_computer_id=? WHERE id=?");
            preparedStatement.setInt(1, t.getCapacity());
            preparedStatement.setInt(2, t.getComputer_computer_id());
            preparedStatement.setInt(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating Ram entity: {}", e.getMessage());
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

    /** Removes a Ram entity from the database.
     * @param t The Ram object to remove.
     */
    @Override
    public void removeEntity(Ram t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM ram WHERE id=?");
            preparedStatement.setInt(1, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting Ram entity: {}", e.getMessage());
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

    /** Retrieves all Ram entities from the database.
     * @return A list of Ram objects retrieved from the database.
     */
    @Override
    public List<Ram> getEntities() {
        List<Ram> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from ram");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Ram ram = new Ram();
                ram.setId(resultSet.getInt("id"));
                ram.setCapacity(resultSet.getInt("capacity"));
                ram.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
                list.add(ram);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Ram entities: {}", e.getMessage());
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


    // Additional methods overridden from IRamDAO interface, left blank as not implemented in this class.
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
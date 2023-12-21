package com.solvd.database.dao.jbdc;

import com.solvd.database.ConnectionPool;
import com.solvd.database.dao.IGpuDAO;
import com.solvd.database.model.Gpu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GpuDAO implements IGpuDAO {
    private static Logger logger = LogManager.getLogger(GpuDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(GpuDAO.class);

    /** Retrieves a Gpu entity from the database based on its ID.
     * @param id The ID of the Gpu entity to retrieve.
     * @return A Gpu object retrieved from the database.
     */
    @Override
    public Gpu getEntityById(int id) {
        Connection connection = connectionPool.retrieve();
        Gpu gpu = new Gpu();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from gpu where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                gpu.setId(resultSet.getInt("id"));
                gpu.setMemory(resultSet.getInt("memory"));
                gpu.setBoostClock(resultSet.getInt("boost_cloock"));
                gpu.setComponent_id(resultSet.getInt("Component_id"));
                gpu.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
                gpu.setPrice(resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Gpu entity by ID: {}", e.getMessage());
        } finally {
            connectionPool.putback(connection);
            closeAll(preparedStatement, resultSet);
        }

        return gpu;
    }

    /** Inserts a Gpu entity into the database.
     * @param t The Gpu object to insert.
     */
    @Override
    public void insertEntity(Gpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO gpu (memory, boost_cloock, price, Component_id, Computer_computer_id) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, t.getMemory());
            preparedStatement.setInt(2, t.getBoostClock());
            preparedStatement.setDouble(3, t.getPrice());
            preparedStatement.setInt(4, t.getComponent_id());
            preparedStatement.setInt(5, t.getComputer_computer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting Gpu entity: {}", e.getMessage());
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

    /** Updates a Gpu entity in the database.
     * @param t The Gpu object to update.
     */
    @Override
    public void updateEntity(Gpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE gpu SET memory=?, boost_cloock=?, price=? WHERE id=?");
            preparedStatement.setInt(1, t.getMemory());
            preparedStatement.setInt(2, t.getBoostClock());
            preparedStatement.setDouble(3, t.getPrice());
            preparedStatement.setInt(4, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating Gpu entity: {}", e.getMessage());
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

    /** Removes a Gpu entity from the database.
     * @param t The Gpu object to remove.
     */
    @Override
    public void removeEntity(Gpu t) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM gpu WHERE id=?");
            preparedStatement.setInt(1, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting Gpu entity: {}", e.getMessage());
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

    /** Retrieves all Gpu entities from the database.
     * @return A list of Gpu objects retrieved from the database.
     */
    @Override
    public List<Gpu> getEntities() {
        List<Gpu> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from gpu");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Gpu gpu = new Gpu();
                gpu.setId(resultSet.getInt("id"));
                gpu.setMemory(resultSet.getInt("memory"));
                gpu.setBoostClock(resultSet.getInt("boost_cloock"));
                gpu.setComponent_id(resultSet.getInt("Component_id"));
                gpu.setComputer_computer_id(resultSet.getInt("Computer_computer_id"));
                gpu.setPrice(resultSet.getDouble("price"));
                list.add(gpu);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving Gpu entities: {}", e.getMessage());
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

    // Additional methods overridden from IGpuDAO interface, left blank as not implemented in this class.
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
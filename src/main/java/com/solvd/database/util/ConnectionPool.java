package com.solvd.database.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

/**
 * Utility class to manage a connection pool for database connections.
 */
public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final int CON_POOL_SIZE = 5;
    private static Properties properties = new Properties();
    private static String userName;
    private static String url;
    private static String password;
    private Vector<Connection> conPool = new Vector<>(CON_POOL_SIZE, 1);
    private Vector<Connection> activeConnections = new Stack<>();

    // Constructor to initialize the Connection Pool
    private ConnectionPool() {
        for (int i = 0; i < CON_POOL_SIZE; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                LOGGER.error("Error creating connection pool: " + e.getMessage());
            }
            conPool.add(connection);
        }
    }

    private static ConnectionPool instance = null;

    // Singleton pattern to get the instance of ConnectionPool
    public static ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }

    // Load the database properties from file when the class is loaded
    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Error loading properties: " + e.getMessage());
        }
        url = properties.getProperty("db.url");
        userName = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }

    /**
     * Gets a new database connection.
     *
     * @return A new Connection object.
     */
    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            LOGGER.error("Error getting connection: " + e.getMessage());
        }
        return conn;
    }

    /**
     * Retrieves a connection from the pool.
     *
     * @return A Connection object retrieved from the pool.
     */
    public synchronized Connection retrieve() {
        Connection newConn = null;
        if (conPool.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = conPool.lastElement();
            conPool.removeElement(newConn);
        }
        activeConnections.addElement(newConn);
        LOGGER.info("The connection was retrieved: " + newConn.toString());
        return newConn;
    }

    /**
     * Puts a connection back into the pool.
     *
     * @param connection The Connection object to be put back into the pool.
     */
    public synchronized void putback(Connection connection) {
        if (connection != null) {
            if (activeConnections.removeElement(connection)) {
                conPool.addElement(connection);
                LOGGER.info("Putting the connection back to Connection pool: " + connection.toString());
            } else {
                throw new NullPointerException("Connection is not in the Active Connections array");
            }
        }
    }
}
package com.solvd.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementation of ConnectionFactory using DriverManager.
 */
public class DriverManagerConnectionFactory implements ConnectionFactory {
    private final String url;
    private final String userName;
    private final String password;

    public DriverManagerConnectionFactory(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
//            ConnectionPool.LOGGER.error("Error creating connection: " + e.getMessage());
            throw new RuntimeException("Error creating connection", e);
        }
    }
}
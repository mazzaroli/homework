package com.solvd.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ConnectionPool class represents a pool of connections.
 */
public class ConnectionPool {
    private final int poolSize;
    private final BlockingQueue<Connection> connections;

    /**
     * Private constructor to create a ConnectionPool instance with a specified pool size.
     * @param poolSize The size of the connection pool.
     */
    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new ArrayBlockingQueue<>(poolSize);
        initializePool();
    }

    /**
     * Initializes the connection pool by creating and adding connections to the pool.
     */
    private void initializePool() {
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection()); // You might have a real connection creation logic here
        }
    }

    /**
     * Creates a new ConnectionPool with the specified pool size.
     * @param poolSize The size of the connection pool.
     * @return A new ConnectionPool instance.
     */
    public static ConnectionPool createPool(int poolSize) {
        return new ConnectionPool(poolSize);
    }

    /**
     * Retrieves a connection from the pool, waiting for a maximum of 5 seconds.
     * @return A Connection object from the pool, or null if the timeout occurs.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public Connection getConnection() throws InterruptedException {
        Connection connection = connections.poll(5, TimeUnit.SECONDS);
        if (connection != null) {
            connection.connect(); // Simulating connection establishment
        }
        return connection;
    }

    /**
     * Releases a connection back to the pool.
     * @param connection The Connection object to be released back to the pool.
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connection.disconnect(); // Simulating connection closure
            connections.offer(connection);
        }
    }
}
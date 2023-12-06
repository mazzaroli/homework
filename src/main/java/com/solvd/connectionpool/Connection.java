package com.solvd.connectionpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Connection class represents a connection object.
 */
public class Connection {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int connectionId;

    /**
     * Constructor to create a Connection object and initialize its unique connection ID.
     */
    public Connection() {
        this.connectionId = idGenerator.incrementAndGet();
        // Any initialization logic for the connection can go here
    }

    /**
     * Simulates establishing a connection.
     * Replace this method with actual connection logic to a database or service.
     */
    public void connect() {
        // Logic to establish the connection
        System.out.println("Connection " + connectionId + " established.");
    }

    /**
     * Simulates closing a connection.
     * Replace this method with actual disconnection logic from a database or service.
     */
    public void disconnect() {
        // Logic to close the connection
        System.out.println("Connection " + connectionId + " closed.");
    }

    // Other methods related to database operations using this connection can be added

    /**
     * Overrides the toString() method to represent the Connection object as a string.
     * @return A string representation of the Connection object.
     */
    @Override
    public String toString() {
        return "Connection " + connectionId;
    }
}
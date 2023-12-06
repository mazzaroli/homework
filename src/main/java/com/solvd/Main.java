package com.solvd;

import com.solvd.connectionpool.Connection;
import com.solvd.connectionpool.ConnectionPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Define the size of the connection pool
        final int poolSize = 5;

        // Create a connection pool with the specified size
        final ConnectionPool connectionPool = ConnectionPool.createPool(poolSize);

        // Create a thread pool with 7 threads
        final ExecutorService threadPool = Executors.newFixedThreadPool(7);

        // Create 7 threads to get connections and perform work
        for (int i = 0; i < 7; i++) {
            threadPool.submit(() -> {
                try {
                    // Get a connection from the pool
                    Connection connection = connectionPool.getConnection();

                    // Print thread ID, thread name, and the acquired connection
                    System.out.println(String.format("[id: %d] %s got connection: %s",
                            Thread.currentThread().getId(),
                            Thread.currentThread().getName(),
                            connection));

                    // Simulate some work with the connection by sleeping for 1 second
                    Thread.sleep(1000);

                    // Release the connection back to the pool
                    connectionPool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the thread pool
        threadPool.shutdown();

        try {
            // Wait for all threads to finish
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
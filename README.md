# Homework Readme

## Threads, Connection Pool, and Thread-Safe Initialization

This homework involves the creation of threads using both `Runnable` and `Thread`, building a thread-safe connection pool using collections from the `java.util.concurrent` package, and demonstrating lazy initialization of the pool. Additionally, simulate the behavior of threads loading the connection pool and using a thread pool to manage the connections.

### Task Overview

1. **Thread Creation**: Implement 2 threads using both `Runnable` and `Thread`.
2. **Connection Pool**: Create a connection pool that is thread-safe and lazily initialized, using collections from `java.util.concurrent`. The `Connection` class can be mocked for simulation purposes.
3. **Initialization with 5 Connections**: Initialize the pool with 5 connections.
4. **Thread Loading and Usage**: Simulate 7 threads (5 threads and a thread pool of 7 threads) attempting to access the connection pool.
    - 5 threads should successfully acquire a connection.
    - 2 threads should wait for the next available connection.

### Additional Information

- **Threads Creation**: Threads can be created either by implementing the `Runnable` interface or by extending the `Thread` class.
- **Connection Pool**: A connection pool is a collection of reusable connections. Ensure thread safety during access to the pool and lazily initialize it for efficiency.
- **Simulation**: Mock the `Connection` class for simulating connections in the pool. Demonstrate thread behavior in acquiring and waiting for available connections.

### Implementation Guidelines

1. **Thread Creation**: Create 2 threads using both `Runnable` and `Thread`.
2. **Connection Pool Implementation**: Implement the connection pool using concurrent collections (`ConcurrentLinkedQueue`, `Semaphore`, etc.) from `java.util.concurrent`.
3. **Initialization and Loading**: Initialize the pool with 5 connections and simulate 7 threads trying to access the pool, ensuring appropriate thread synchronization and waiting for available connections.
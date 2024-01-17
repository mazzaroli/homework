package com.solvd.database.util;

import java.sql.Connection;

/**
 * Factory interface for creating Connection objects.
 */
public interface ConnectionFactory {
    Connection createConnection();
}
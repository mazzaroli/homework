package com.solvd.database.util;

import com.solvd.database.JdbcDAOFactory;
import com.solvd.database.MyBatisDAOFactory;
import com.solvd.enums.FactoryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class responsible for generating instances of AbstractFactory based on the provided FactoryType.
 */
public class DAOFactoryGenerator {
    private static Logger logger = LogManager.getLogger(DAOFactoryGenerator.class);

    /**
     * Creates a factory instance based on the provided type.
     *
     * @param factoryType The type of factory to create (JDBC or MyBatis).
     * @return An instance of AbstractFactory based on the provided type.
     */
    public static AbstractFactory createFactory(FactoryType factoryType) {
        switch (factoryType) {
            case MYBATIS:
                return new MyBatisDAOFactory();
            case JDBC:
                return new JdbcDAOFactory();
            default:
                logger.error("Incorrect value of database implementation: " + factoryType);
                return null;
        }
    }
}
package com.solvd.database.util.dao;

import com.solvd.database.dao.IBaseDao;
import com.solvd.database.dao.mybatis.CpuDAO;
import com.solvd.database.dao.mybatis.GpuDAO;
import com.solvd.database.dao.mybatis.RamDAO;
import com.solvd.database.proxy.RamDAOProxy;
import com.solvd.database.util.abstractFactory.AbstractFactory;
import com.solvd.enums.DAOType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * MyBatis implementation of the DAO factory.
 */
public class MyBatisDAOFactory extends AbstractFactory {
    private static final Logger logger = LogManager.getLogger(MyBatisDAOFactory.class);

    /**
     * Creates a DAO instance based on the provided DAOType.
     *
     * @param dao The type of DAO to create (CPU, GPU, or RAM).
     * @return An instance of IBaseDao based on the provided DAOType.
     */
    public static IBaseDao createDAO(DAOType dao) {
        switch (dao) {
            case CPU:
                return new CpuDAO();
            case GPU:
                return new GpuDAO();
            case RAM:
                return new RamDAOProxy();
            default:
                logger.error("Unexpected value: " + dao);
                return null;
        }
    }

    /**
     * Gets the factory based on the provided DAOType.
     *
     * @param factory The type of DAO factory to get (CPU, GPU, or RAM).
     * @return An instance of IBaseDao based on the provided DAOType.
     */
    @Override
    public IBaseDao getFactory(DAOType factory) {
        return createDAO(factory);
    }
}
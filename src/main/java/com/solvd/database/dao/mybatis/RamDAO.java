package com.solvd.database.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.database.dao.IRamDAO;
import com.solvd.database.model.Ram;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RamDAO implements IRamDAO {
    private static final Logger LOGGER = LogManager.getLogger(RamDAO.class);
    private static IRamDAO ramMapper;
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Override
    public Ram getEntityById(int id) {
        ramMapper = sqlSessionFactory.openSession().getMapper(IRamDAO.class);
        Ram ram = ramMapper.getEntityById(id);
        return ram;
    }

    @Override
    public void insertEntity(Ram entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();

            // Build a RamBuilder object to use the Builder pattern
            Ram.RamBuilder ramBuilder = new Ram.RamBuilder();
            ramBuilder
                    .id(entity.getId())
                    .capacity(entity.getCapacity())
                    .computerId(entity.getComputer_computer_id());

            // Insert the built object into the database
            sqlSession.insert("insertRam", ramBuilder.build());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Ram entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateRam", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Ram entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeRam", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Ram> getEntities() {
        List<Ram> rams;
        try {
            sqlSession = sqlSessionFactory.openSession();

            // Perform the database selection
            rams = sqlSession.selectList("getRams");

            // Rebuild Ram objects using the Builder pattern
            List<Ram> rebuiltRams = new ArrayList<>();
            for (Ram ram : rams) {
                Ram.RamBuilder ramBuilder = new Ram.RamBuilder();
                ramBuilder
                        .id(ram.getId())
                        .capacity(ram.getCapacity())
                        .computerId(ram.getComputer_computer_id());

                rebuiltRams.add(ramBuilder.build());
            }
            rams = rebuiltRams;
        } finally {
            sqlSession.close();
        }
        return rams;
    }

    @Override
    public void insertEntity(Object o) {
        // Placeholder method, not implemented
    }

    @Override
    public void updateEntity(Object o, int i) {
        // Placeholder method, not implemented
    }

    @Override
    public void removeEntity(Object o) {
        // Placeholder method, not implemented
    }
}
package com.solvd.database.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.database.dao.IRamDAO; // Cambiado desde IGpuDAO a IRamDAO
import com.solvd.database.model.Ram; // Cambiado desde Gpu a Ram

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class RamDAO implements IRamDAO { // Cambiado desde GpuDAO a RamDAO
    private static final Logger LOGGER = LogManager.getLogger(RamDAO.class); // Cambiado desde GpuDAO a RamDAO
    private static IRamDAO ramMapper; // Cambiado desde IGpuDAO a IRamDAO
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
    public Ram getEntityById(int id) { // Cambiado desde Gpu a Ram
        ramMapper = sqlSessionFactory.openSession().getMapper(IRamDAO.class); // Cambiado desde IGpuDAO a IRamDAO
        Ram ram = ramMapper.getEntityById(id); // Cambiado desde Gpu a Ram
        return ram;
    }

    @Override
    public void insertEntity(Ram entity) { // Cambiado desde Gpu a Ram
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertRam", entity); // Cambiado desde insertGpu a insertRam
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Ram entity) { // Cambiado desde Gpu a Ram
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateRam", entity); // Cambiado desde updateGpu a updateRam
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Ram entity) { // Cambiado desde Gpu a Ram
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeRam", entity); // Cambiado desde removeGpu a removeRam
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Ram> getEntities() { // Cambiado desde Gpu a Ram
        List<Ram> rams; // Cambiado desde List<Gpu> a List<Ram>
        try {
            sqlSession = sqlSessionFactory.openSession();
            rams = sqlSession.selectList("getRams"); // Cambiado a showAllRams para reflejar RAMs
        } finally {
            sqlSession.close();
        }
        return rams; // Cambiado desde gpus a rams
    }

    @Override
    public void insertEntity(Object o) {

    }

    @Override
    public void updateEntity(Object o, int i) {

    }

    @Override
    public void removeEntity(Object o) {

    }
}
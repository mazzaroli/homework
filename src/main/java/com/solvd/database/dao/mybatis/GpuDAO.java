package com.solvd.database.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.database.dao.IGpuDAO;
import com.solvd.database.model.Gpu;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GpuDAO implements IGpuDAO { // Cambiado desde CpuDAO a GpuDAO
    private static final Logger LOGGER = LogManager.getLogger(GpuDAO.class); // Cambiado desde CpuDAO a GpuDAO
    private static IGpuDAO gpuMapper; // Cambiado desde ICpuDAO a IGpuDAO
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
    public Gpu getEntityById(int id) { // Cambiado desde Cpu a Gpu
        gpuMapper = sqlSessionFactory.openSession().getMapper(IGpuDAO.class); // Cambiado desde ICpuDAO a IGpuDAO
        Gpu gpu = gpuMapper.getEntityById(id); // Cambiado desde Cpu a Gpu
        return gpu;
    }

    @Override
    public void insertEntity(Gpu entity) { // Cambiado desde Cpu a Gpu
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertGpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Gpu entity) { // Cambiado desde Cpu a Gpu
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateGpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Gpu entity) { // Cambiado desde Cpu a Gpu
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeGpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Gpu> getEntities() { // Cambiado desde Cpu a Gpu
        List<Gpu> gpus; // Cambiado desde List<Cpu> a List<Gpu>
        try {
            sqlSession = sqlSessionFactory.openSession();
            gpus = sqlSession.selectList("getGpus"); // Cambiado a showAllGpus para reflejar GPUs
        } finally {
            sqlSession.close();
        }
        return gpus; // Cambiado desde cpus a gpus
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
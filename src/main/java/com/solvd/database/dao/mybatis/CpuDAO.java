package com.solvd.database.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.database.dao.ICpuDAO;
import com.solvd.database.model.Cpu;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CpuDAO implements ICpuDAO {
    private static final Logger LOGGER = LogManager.getLogger(CpuDAO.class);
    private static ICpuDAO cpuMapper;
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
    public Cpu getEntityById(int id) {
        cpuMapper = sqlSessionFactory.openSession().getMapper(ICpuDAO.class);
        Cpu cpu = cpuMapper.getEntityById(id);
        return cpu;
    }

    @Override
    public void insertEntity(Cpu entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertCpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Cpu entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateCpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Cpu entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeCpu", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Cpu> getEntities() {
        List<Cpu> cpus;
        try {
            sqlSession = sqlSessionFactory.openSession();
            cpus = sqlSession.selectList("getCpus"); // Cambiado a showAllCpus para reflejar CPUs
        } finally {
            sqlSession.close();
        }
        return cpus;
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
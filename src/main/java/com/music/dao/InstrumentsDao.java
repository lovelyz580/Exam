package com.music.dao;


import com.music.entity.Instruments;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentsDao {
    private Logger logger = Logger.getLogger(InstrumentsDao.class);

    public int insert(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.insert("com.music.dao.mapper.Instruments.insert", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.insert("com.music.dao.mapper.Instruments.insertSelective", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.update("com.music.dao.mapper.Instruments.updateByPrimaryKeySelective", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.update("com.music.dao.mapper.Instruments.updateByPrimaryKey", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.selectOne("com.music.dao.mapper.Instruments.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public Instruments selectByPrimaryKey(SqlSession session, Integer id) {
        Instruments instruments = new Instruments();

        try {
            logger.info("InstrumentsDao");

            instruments = session.selectOne("com.music.dao.mapper.Instruments.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return instruments;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.delete("com.music.dao.mapper.Instruments.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("InstrumentsDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据Instruments实体添加
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByInstruments(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.insert("com.music.dao.mapper.Instruments.insertByInstruments", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--insertByInstruments--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体更新
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByInstruments(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.update("com.music.dao.mapper.Instruments.updateByInstruments", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--updateByInstruments--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体查询
     *
     * 查询数量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByInstruments(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.selectOne("com.music.dao.mapper.Instruments.selectCountByInstruments", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectCountByInstruments--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Instruments> selectByInstruments(SqlSession session, Instruments instruments) {
        List<Instruments> instrumentsList = new ArrayList<Instruments>();

        try {
            logger.info("InstrumentsDao");

            instrumentsList = session.selectList("com.music.dao.mapper.Instruments.selectByInstruments", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectByInstruments--error:" + e.getMessage());
        }

        return instrumentsList;
    }

    /**
     * 根据Instruments实体模糊查询
     *
     * 查询数量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.selectOne("com.music.dao.mapper.Instruments.selectCountBySelectData", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Instruments> selectBySelectData(SqlSession session, Instruments instruments) {
        List<Instruments> instrumentsList = new ArrayList<Instruments>();

        try {
            logger.info("InstrumentsDao");

            instrumentsList = session.selectList("com.music.dao.mapper.Instruments.selectBySelectData", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--selectBySelectData--error:" + e.getMessage());
        }

        return instrumentsList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByInstrumentsDeleteState(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.update("com.music.dao.mapper.Instruments.updateByInstrumentsDeleteState", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--updateByInstrumentsDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据Instruments实体删除
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int deleteByInstruments(SqlSession session, Instruments instruments) {
        int num = 0;

        try {
            logger.info("InstrumentsDao");

            num = session.delete("com.music.dao.mapper.Instruments.deleteByInstruments", instruments);
        } catch (Exception e) {
            logger.error("InstrumentsDao--deleteByInstruments--error:" + e.getMessage());
        }

        return num;
    }
}
package com.music.service;

import com.music.dao.InstrumentsDao;
import com.music.entity.Instruments;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-03-18 14:15
 */
@Service
public class InstrumentsService {

    @Autowired
    private InstrumentsDao instrumentsDao;

    private Logger logger = Logger.getLogger(InstrumentsService.class);

    /**
     * 根据Admin实体添加
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByInstruments(Instruments instruments) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = instrumentsDao.insertByInstruments(session, instruments);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--insertByInstruments--error:" + e.getMessage());
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
    public int updateByInstruments(Instruments instruments) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = instrumentsDao.updateByInstruments(session, instruments);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--updateByInstruments--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体联表查询
     *
     * 查询数量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByInstruments(Instruments instruments) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = instrumentsDao.selectCountByInstruments(session, instruments);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--selectCountByInstruments--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体联表查询
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
    public List<Instruments> selectByInstruments(Instruments instruments) {
        List<Instruments> instrumentsList = new ArrayList<Instruments>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            instrumentsList = instrumentsDao.selectByInstruments(session, instruments);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--selectByInstruments--error:" + e.getMessage());
        }

        return instrumentsList;
    }

    /**
     * 根据Instruments实体联表模糊查询
     *
     * 查询数量
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(Instruments instruments) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = instrumentsDao.selectCountBySelectData(session, instruments);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Instruments实体联表模糊查询
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
    public List<Instruments> selectBySelectData(Instruments instruments) {
        List<Instruments> instrumentsList = new ArrayList<Instruments>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            instrumentsList = instrumentsDao.selectBySelectData(session, instruments);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectBySelectData--error:" + e.getMessage());
        }

        return instrumentsList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByInstrumentsDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                Instruments instruments = new Instruments();
                instruments.setInsId(list.get(i));
                instruments.setInsIsdel(0);//删除
                instruments.setInsUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + instrumentsDao.updateByInstrumentsDeleteState(session, instruments);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--updateByInstrumentsDeleteState--error:" + e.getMessage());
        }

        return deleteNum;
    }


    /**
     * 根据idList删除信息
     *
     * @param list
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int deleteByIdList(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                deleteNum = deleteNum + instrumentsDao.deleteByPrimaryKey(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("InstrumentsService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}



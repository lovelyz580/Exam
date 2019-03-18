package com.music.dao;

import com.music.entity.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AdminDao {
    private Logger logger = Logger.getLogger(AdminDao.class);

    public int insert(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.insert("com.music.dao.mapper.Admin.insert", admin);
        } catch (Exception e) {
            logger.error("AdminDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.insert("com.music.dao.mapper.Admin.insertSelective", admin);
        } catch (Exception e) {
            logger.error("AdminDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.update("com.music.dao.mapper.Admin.updateByPrimaryKeySelective", admin);
        } catch (Exception e) {
            logger.error("AdminDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.update("com.music.dao.mapper.Admin.updateByPrimaryKey", admin);
        } catch (Exception e) {
            logger.error("AdminDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.selectOne("com.music.dao.mapper.Admin.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("AdminDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public Admin selectByPrimaryKey(SqlSession session, Integer id) {
        Admin admin = new Admin();

        try {
            logger.info("AdminDao");

            admin = session.selectOne("com.music.dao.mapper.Admin.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("AdminDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return admin;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.delete("com.music.dao.mapper.Admin.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("UserDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据Admin实体添加
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByUser(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.insert("com.music.dao.mapper.Admin.insertByUser", admin);
        } catch (Exception e) {
            logger.error("AdminDao--insertByUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体更新
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByAdmin(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.update("com.music.dao.mapper.Admin.updateByAdmin", admin);
        } catch (Exception e) {
            logger.error("AdminDao--updateByAdmin--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体查询
     *
     * 查询数量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByAdmin(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.selectOne("com.music.dao.mapper.Admin.selectCountByAdmin", admin);
        } catch (Exception e) {
            logger.error("AdminDao--selectCountByAdmin--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Admin> selectByAdmin(SqlSession session, Admin admin) {
        List<Admin> adminList = new ArrayList<Admin>();

        try {
            logger.info("AdminDao");

            adminList = session.selectList("com.music.dao.mapper.Admin.selectByAdmin", admin);
        } catch (Exception e) {
            logger.error("AdminDao--selectByAdmin--error:" + e.getMessage());
        }

        return adminList;
    }

    /**
     * 根据Admin实体模糊查询
     *
     * 查询数量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.selectOne("com.music.dao.mapper.Admin.selectCountBySelectData", admin);
        } catch (Exception e) {
            logger.error("AdminDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Admin> selectBySelectData(SqlSession session, Admin admin) {
        List<Admin> userList = new ArrayList<Admin>();

        try {
            logger.info("AdminDao");

            userList = session.selectList("com.music.dao.mapper.Admin.selectBySelectData", admin);
        } catch (Exception e) {
            logger.error("AdminDao--selectBySelectData--error:" + e.getMessage());
        }

        return userList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByAdminDeleteState(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.update("com.music.dao.mapper.Admin.updateByAdminDeleteState", admin);
        } catch (Exception e) {
            logger.error("AdminDao--updateByAdminDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据Admin实体删除
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int deleteByAdmin(SqlSession session, Admin admin) {
        int num = 0;

        try {
            logger.info("AdminDao");

            num = session.delete("com.music.dao.mapper.Admin.deleteByAdmin", admin);
        } catch (Exception e) {
            logger.error("AdminDao--deleteByAdmin--error:" + e.getMessage());
        }

        return num;
    }
}
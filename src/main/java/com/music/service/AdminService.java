package com.music.service;

import com.music.dao.AdminDao;
import com.music.entity.Admin;
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
 * on 2019-03-18 10:30
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    private Logger logger = Logger.getLogger(AdminService.class);

    /**
     * 根据Admin实体添加
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByAdmin(Admin admin) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = adminDao.insertByUser(session, admin);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--insertByAdmin--error:" + e.getMessage());
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
    public int updateByAdmin(Admin admin) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = adminDao.updateByAdmin(session, admin);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--updateByAdmin--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体联表查询
     *
     * 查询数量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByAdmin(Admin admin) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = adminDao.selectCountByAdmin(session, admin);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectCountByAdmin--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体联表查询
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
    public List<Admin> selectByAdmin(Admin admin) {
        List<Admin> adminList = new ArrayList<Admin>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            adminList = adminDao.selectByAdmin(session, admin);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectByAdmin--error:" + e.getMessage());
        }

        return adminList;
    }

    /**
     * 根据Admin实体联表模糊查询
     *
     * 查询数量
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(Admin admin) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = adminDao.selectCountBySelectData(session, admin);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Admin实体联表模糊查询
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
    public List<Admin> selectBySelectData(Admin admin) {
        List<Admin> adminList = new ArrayList<Admin>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            adminList = adminDao.selectBySelectData(session, admin);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectBySelectData--error:" + e.getMessage());
        }

        return adminList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByUserDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                Admin admin = new Admin();
                admin.setAdmId(list.get(i));
                admin.setAdmIsdel(0);//删除
                admin.setAdmUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + adminDao.updateByAdminDeleteState(session, admin);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--updateByAdminDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + adminDao.deleteByPrimaryKey(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}



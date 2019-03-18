package com.music.service;

import com.music.dao.StudentDao;
import com.music.entity.Student;
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
 * on 2019-03-18 16:27
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    private Logger logger = Logger.getLogger(StudentService.class);

    /**
     * 根据Student实体添加
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByStudent(Student student) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = studentDao.insertByStudent(session, student);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("StudentService--insertByStudent--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体更新
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByStudent(Student student) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = studentDao.updateByStudent(session, student);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("StudentService--updateByStudent--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体联表查询
     *
     * 查询数量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByStudent(Student student) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = studentDao.selectCountByStudent(session, student);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("StudentService--selectCountByStudent--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Student> selectByStudent(Student student) {
        List<Student> studentList = new ArrayList<Student>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            studentList = studentDao.selectByStudent(session, student);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("StudentService--selectByStudent--error:" + e.getMessage());
        }

        return studentList;
    }

    /**
     * 根据Student实体联表模糊查询
     *
     * 查询数量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(Student student) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = studentDao.selectCountBySelectData(session, student);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("StudentService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public List<Student> selectBySelectData(Student student) {
        List<Student> studentList = new ArrayList<Student>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            studentList = studentDao.selectBySelectData(session, student);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("AdminService--selectBySelectData--error:" + e.getMessage());
        }

        return studentList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByStudentDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                Student student = new Student();
                student.setStuId(list.get(i));
                student.setStuIsdel(0);//删除
                student.setStuUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + studentDao.updateByStudentDeleteState(session, student);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("studentService--updateBystudentDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + studentDao.deleteByPrimaryKey(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("studentService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}

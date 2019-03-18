package com.music.dao;


import com.music.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {
    private Logger logger = Logger.getLogger(StudentDao.class);

    public int insert(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.insert("com.music.dao.mapper.Student.insert", student);
        } catch (Exception e) {
            logger.error("StudentDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.insert("com.music.dao.mapper.Student.insertSelective", student);
        } catch (Exception e) {
            logger.error("StudentDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.update("com.music.dao.mapper.Student.updateByPrimaryKeySelective", student);
        } catch (Exception e) {
            logger.error("StudentDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.update("com.music.dao.mapper.Student.updateByPrimaryKey", student);
        } catch (Exception e) {
            logger.error("StudentDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.selectOne("com.music.dao.mapper.Student.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("StudentDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public Student selectByPrimaryKey(SqlSession session, String id) {
        Student student = new Student();

        try {
            logger.info("StudentDao");

            student = session.selectOne("com.music.dao.mapper.Student.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("StudentDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return student;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.delete("com.music.dao.mapper.Student.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("StudentDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据Student实体添加
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int insertByStudent(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.insert("com.music.dao.mapper.Student.insertByStudent", student);
        } catch (Exception e) {
            logger.error("StudentDao--insertByStudent--error:" + e.getMessage());
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
    public int updateByStudent(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.update("com.music.dao.mapper.Student.updateByStudent", student);
        } catch (Exception e) {
            logger.error("StudentDao--updateByStudent--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体查询
     *
     * 查询数量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountByStudent(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.selectOne("com.music.dao.mapper.Student.selectCountByStudent", student);
        } catch (Exception e) {
            logger.error("StudentDao--selectCountByStudent--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体查询
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
    public List<Student> selectByStudent(SqlSession session, Student student) {
        List<Student> studentList = new ArrayList<Student>();

        try {
            logger.info("StudentDao");

            studentList = session.selectList("com.music.dao.mapper.Student.selectByStudent", student);
        } catch (Exception e) {
            logger.error("StudentDao--selectByStudent--error:" + e.getMessage());
        }

        return studentList;
    }

    /**
     * 根据Student实体模糊查询
     *
     * 查询数量
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int selectCountBySelectData(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.selectOne("com.music.dao.mapper.Student.selectCountBySelectData", student);
        } catch (Exception e) {
            logger.error("StudentDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据Student实体模糊查询
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
    public List<Student> selectBySelectData(SqlSession session, Student student) {
        List<Student> studentList = new ArrayList<Student>();
        try {
            logger.info("StudentDao");

            studentList = session.selectList("com.music.dao.mapper.Student.selectBySelectData", student);
        } catch (Exception e) {
            logger.error("StudentDao--selectBySelectData--error:" + e.getMessage());
        }

        return studentList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int updateByStudentDeleteState(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.update("com.music.dao.mapper.Student.updateByStudentDeleteState", student);
        } catch (Exception e) {
            logger.error("StudentDao--updateByStudentDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据Student实体删除
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    public int deleteByStudent(SqlSession session, Student student) {
        int num = 0;

        try {
            logger.info("StudentDao");

            num = session.delete("com.music.dao.mapper.Student.deleteByStudent", student);
        } catch (Exception e) {
            logger.error("StudentDao--deleteByStudent--error:" + e.getMessage());
        }

        return num;
    }
}
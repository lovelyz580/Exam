package com.music.restful;

/**
 * Created by Lovelyz
 * on 2019-03-18 16:07
 */

import com.music.entity.Student;
import com.music.service.StudentService;
import com.util.Config;
import com.util.LayuiDataTemplet;
import com.util.MD5Util;
import com.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 学生表
 *
 * Restful
 *
 * @author ZY on 2019/03/12
 */

@Controller
@RequestMapping("/student")
public class F_StudentRestful {

    @Autowired
    private StudentService studentService;

    /**
     * 根据Student实体添加
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/insertByStudent")
    public LayuiDataTemplet<Student> insertByUser(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != student.getVersion() && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        //判断登录名不能重复
        student.setStuAccounts("123456");
        Student studentSelectData = new Student();
        studentSelectData.setPagenumber(-1);//不分页
        studentSelectData.setStuAccounts(student.getStuAccounts());//登录賬號

        List<Student> studentList = studentService.selectByStudent(studentSelectData); // 查询数据
        if (studentList.size() > 0) {
            returnData.setMsg("该登录名已注册、请更换！");
            return returnData;
        }
        student.setStuAccounts("123456");
        student.setStuPassword("123456");
        // 添加数据
        student.setStuPassword(MD5Util.encrypt(student.getStuPassword()));//MD5加密
        student.setStuId(Config.SIGN_STUDENT + UUID.randomUUID().toString()); // 学生ID(XS+UUID)
        student.setStuName("莉莉");
        student.setStuSex(0); // 性别(0:女/1:男)
        student.setStuIsdel(1);//删除状态（0：删除/1：未删除）
        student.setStuUpdatetime(new Date()); // 用户创建时间
        student.setStuCreatetime(new Date());//用户更新时间

        // 添加
        int count = 0;
        count = studentService.insertByStudent(student);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("添加失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("添加成功！");
        }
        return returnData;
    }

    /**
     * 根据Student实体更新
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByStudent")
    public LayuiDataTemplet<Student> updateByUser(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 更新判断
        student.setStuId("XSf0d60858-5e90-4e8d-8af5-e9575f90cfb3");
        if (student.getStuId() == null ) {
            if (student.getStuId() == null || student.getStuId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        //MD5加密
        student.setStuName("我正在更新");
        if (null != student.getStuPassword() && !student.getStuPassword().equals("")){
            student.setStuPassword(MD5Util.encrypt(student.getStuPassword()));
        }
        student.setStuUpdatetime(new Date()); // 更新时间

        // 更新
        int count = 0;
        count = studentService.updateByStudent(student);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("更新失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("更新成功！");
        }

        return returnData;
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
    @ResponseBody
    @RequestMapping("/selectByStudent")
    public LayuiDataTemplet<Student> selectByUser(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (student.getPagenumber() != null) {
            // 计算偏移量
            if (student.getPagenumber() != -1) {
                if (student.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = student.getPagenumber();
                int pageSize = student.getPagesize();
                student.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                student.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = studentService.selectCountByStudent(student);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Student> studentList = studentService.selectByStudent(student); // 查询数据
                returnData.setData(studentList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
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
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Student> selectBySelectData(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (student.getPagenumber() != null) {
            // 计算偏移量
            if (student.getPagenumber() != -1) {
                if (student.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = student.getPagenumber();
                int pageSize = student.getPagesize();
                student.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                student.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            student.setStuName("我");
            count = studentService.selectCountBySelectData(student); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Student> studentList = studentService.selectBySelectData(student); // 查询数据
                returnData.setData(studentList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }



    /**
     * 登录
     *
     *
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/login")
    public LayuiDataTemplet<Student> login(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        student.setStuAccounts("123456");
        student.setStuPassword("123456");
        // 查询用户数据，并判断用户名、密码是否正确
        if (student.getStuAccounts() != null && !student.getStuAccounts().isEmpty() &&
                student.getStuPassword() != null && !student.getStuPassword().isEmpty()) {
            // 根据手机号码查询数据
            Student selectData = new Student();
            selectData.setStuAccounts(student.getStuAccounts()); // 用户登录名
            selectData.setStuPassword(MD5Util.encrypt(student.getStuPassword()));//加密后的密码
            selectData.setStuIsdel(1);//状态启用
            selectData.setPagenumber(-1); // 当前页数(如果不进行分页，该条数据默认为-1)

            // 查询数据
            List<Student> studentList = studentService.selectByStudent(selectData);

            // 判断用户名是否正确
            if (studentList == null || studentList.size() == 0) {
                // 没有该用户
                returnData.setMsg("没有该用户！");
            } else {
                // 判断密码是否正确
                if (!MD5Util.encrypt(student.getStuPassword()).equals(studentList.get(0).getStuPassword())) {
                    // 没有该用户
                    returnData.setMsg("密码错误！");
                } else {
                    returnData.setData(studentList);
                    returnData.setMsg("登录成功！");
                }
            }
        } else {
            // 传递的客户数据错误
            returnData.setMsg("传递的登录数据错误！");
        }

        return returnData;
    }



    /**
     * 根据Student实体删除信息(假删，更改状态)(0:删除、1：未删除)
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByAdminDeleteState")
    public LayuiDataTemplet<Student> updateByUserDeleteState(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        count = studentService.updateByStudentDeleteState(student.getIdlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }



    /**
     * 根据idList删除信息
     *
     * @param student
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<Student> deleteByIdList(@RequestBody Student student) {
        LayuiDataTemplet<Student> returnData = new LayuiDataTemplet<Student>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (student.getVersion() != null && !student.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(student.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        count = studentService.deleteByIdList(student.getIdlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }

}

package com.music.restful;

/**
 * Created by Lovelyz
 * on 2019-03-18 10:29
 */


import com.music.entity.Admin;
import com.music.service.AdminService;
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
 * 管理員表
 *
 * Restful
 *
 * @author ZY on 2019/03/12
 */

@Controller
@RequestMapping("/admin")
public class F_AdminRestful {

    @Autowired
    private AdminService adminService;

    /**
     * 根据User实体添加
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/insertByAdmin")
    public LayuiDataTemplet<Admin> insertByUser(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != admin.getVersion() && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        Admin adminSelectData = new Admin();
        adminSelectData.setPagenumber(-1);//不分页
        adminSelectData.setAdmAccounts(admin.getAdmAccounts());//登录賬號

        List<Admin> adminList = adminService.selectByAdmin(adminSelectData); // 查询数据
        if (adminList.size() > 0) {
            returnData.setMsg("该登录名已注册、请更换！");
            return returnData;
        }
        admin.setAdmName("测试");
        admin.setAdmPassword("123456");
        // 添加数据
        admin.setAdmPassword(MD5Util.encrypt(admin.getAdmPassword()));//MD5加密
        admin.setAdmId(Config.SIGN_ADMIN + UUID.randomUUID().toString()); // 管理員ID(YH+UUID)
        admin.setAdmIsroot(0); // 管理员状态状态(0:普通管理员/1:超级管理员)
        admin.setAdmIsdel(1);//删除状态（Y：删除/N：未删除）
        admin.setAdmCreatetime(new Date()); // 用户创建时间
        admin.setAdmUpdatetime(new Date());//用户更新时间

        // 添加
        int count = 0;
        count = adminService.insertByAdmin(admin);

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
     * 根据Admin实体更新
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByAdmin")
    public LayuiDataTemplet<Admin> updateByUser(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        admin.setAdmId("AD86af0b96-5f51-4c2a-bdab-9a587b5852f4");
        if (admin.getAdmId() == null ) {
            if (admin.getAdmId() == null || admin.getAdmId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        //MD5加密
        admin.setAdmName("我正在更新");
        if (null != admin.getAdmPassword() && !admin.getAdmPassword().equals("")){
            admin.setAdmPassword(MD5Util.encrypt(admin.getAdmPassword()));
        }
        admin.setAdmUpdatetime(new Date()); // 更新时间

        // 更新
        int count = 0;
        count = adminService.updateByAdmin(admin);

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
    @ResponseBody
    @RequestMapping("/selectByAdmin")
    public LayuiDataTemplet<Admin> selectByUser(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        if (admin.getPagenumber() != null) {
            // 计算偏移量
            if (admin.getPagenumber() != -1) {
                if (admin.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = admin.getPagenumber();
                int pageSize = admin.getPagesize();
                admin.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                admin.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = adminService.selectCountByAdmin(admin);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Admin> adminList = adminService.selectByAdmin(admin); // 查询数据
                returnData.setData(adminList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
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
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Admin> selectBySelectData(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        if (admin.getPagenumber() != null) {
            // 计算偏移量
            if (admin.getPagenumber() != -1) {
                if (admin.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = admin.getPagenumber();
                int pageSize = admin.getPagesize();
                admin.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                admin.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            admin.setAdmName("我");
            count = adminService.selectCountBySelectData(admin); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Admin> adminList = adminService.selectBySelectData(admin); // 查询数据
                returnData.setData(adminList);
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
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/login")
    public LayuiDataTemplet<Admin> login(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
   admin.setAdmAccounts("123456");
        admin.setAdmPassword("123456");
        // 查询用户数据，并判断用户名、密码是否正确
        if (admin.getAdmAccounts() != null && !admin.getAdmAccounts().isEmpty() &&
                admin.getAdmPassword() != null && !admin.getAdmPassword().isEmpty()) {
            // 根据手机号码查询数据
            Admin selectData = new Admin();
            selectData.setAdmAccounts(admin.getAdmAccounts()); // 用户登录名
            selectData.setAdmPassword(MD5Util.encrypt(admin.getAdmPassword()));//加密后的密码
            selectData.setAdmIsdel(1);//状态启用
            selectData.setPagenumber(-1); // 当前页数(如果不进行分页，该条数据默认为-1)

            // 查询数据
            List<Admin> adminList = adminService.selectByAdmin(selectData);

            // 判断用户名是否正确
            if (adminList == null || adminList.size() == 0) {
                // 没有该用户
                returnData.setMsg("没有该用户！");
            } else {
                // 判断密码是否正确
                if (!MD5Util.encrypt(admin.getAdmPassword()).equals(adminList.get(0).getAdmPassword())) {
                    // 没有该用户
                    returnData.setMsg("密码错误！");
                } else {
                    returnData.setData(adminList);
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
     * 根据Admin实体删除信息(假删，更改状态)(0:删除、1：未删除)
     *
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByAdminDeleteState")
    public LayuiDataTemplet<Admin> updateByUserDeleteState(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        count = adminService.updateByUserDeleteState(admin.getIdlist());

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
     * @param admin
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<Admin> deleteByIdList(@RequestBody Admin admin) {
        LayuiDataTemplet<Admin> returnData = new LayuiDataTemplet<Admin>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (admin.getVersion() != null && !admin.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(admin.getVersion(), Config.VERSION);
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
        count = adminService.deleteByIdList(admin.getIdlist());

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
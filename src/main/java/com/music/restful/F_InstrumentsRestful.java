package com.music.restful;

/**
 * Created by Lovelyz
 * on 2019-03-18 13:48
 */
import com.music.entity.Instruments;
import com.music.service.InstrumentsService;
import com.util.Config;
import com.util.LayuiDataTemplet;
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
 * 乐器表
 *
 * Restful
 *
 * @author ZY on 2019/03/12
 */

@Controller
@RequestMapping("/instruments")
public class F_InstrumentsRestful {

    @Autowired
    private InstrumentsService instrumentsService;

    /**
     * 根据Instruments实体添加
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/insertByInstruments")
    public LayuiDataTemplet<Instruments> insertByInstruments(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != instruments.getVersion() && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        Instruments instrumentsListData = new Instruments();
        instrumentsListData.setPagenumber(-1);//不分页
        instruments.setInsName("萨克斯管");
        instrumentsListData.setInsName(instruments.getInsName());//名称

        List<Instruments> instrumentsList = instrumentsService.selectByInstruments(instrumentsListData); // 查询数据
        if (instrumentsList.size() > 0) {
            returnData.setMsg("该乐器名已注册、请更换！");
            return returnData;
        }
        instrumentsListData.setInsName("萨克斯管");

        // 添加数据
        instrumentsListData.setInsId(Config.SIGN_YQ + UUID.randomUUID().toString()); // 管理員ID(YH+UUID)
        instrumentsListData.setInsIsdel(1);//删除状态（0：删除/1：未删除）
        instrumentsListData.setInsCreatetime(new Date()); // 用户创建时间
        instrumentsListData.setInsUpdatetime(new Date());//用户更新时间

        // 添加
        int count = 0;
        count = instrumentsService.insertByInstruments(instrumentsListData);

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
     * 根据Instruments实体更新
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByInstruments")
    public LayuiDataTemplet<Instruments> updateByInstruments(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (instruments.getVersion() != null && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        instruments.setInsId("YQ4b139f9c-3aa7-47ee-9656-01b0cc80367e");
        if (instruments.getInsId() == null ) {
            if (instruments.getInsId() == null || instruments.getInsId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        instruments.setInsName("我正在更新");
        instruments.setInsUpdatetime(new Date()); // 更新时间
        // 更新
        int count = 0;
        count = instrumentsService.updateByInstruments(instruments);

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
    @ResponseBody
    @RequestMapping("/selectByInstruments")
    public LayuiDataTemplet<Instruments> selectByInstruments(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (instruments.getVersion() != null && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        if (instruments.getPagenumber() != null) {
            // 计算偏移量
            if (instruments.getPagenumber() != -1) {
                if (instruments.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = instruments.getPagenumber();
                int pageSize = instruments.getPagesize();
                instruments.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                instruments.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = instrumentsService.selectCountByInstruments(instruments);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Instruments> instrumentsList = instrumentsService.selectByInstruments(instruments); // 查询数据
                returnData.setData(instrumentsList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
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
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Instruments> selectBySelectData(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (instruments.getVersion() != null && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        if (instruments.getPagenumber() != null) {
            // 计算偏移量
            if (instruments.getPagenumber() != -1) {
                if (instruments.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = instruments.getPagenumber();
                int pageSize = instruments.getPagesize();
                instruments.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                instruments.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            instruments.setInsName("我");
            count = instrumentsService.selectCountBySelectData(instruments); // 查询数量
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Instruments> instrumentsList = instrumentsService.selectBySelectData(instruments); // 查询数据
                returnData.setData(instrumentsList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }


    /**
     * 根据Instruments实体删除信息(假删，更改状态)(0:删除、1：未删除)
     *
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/updateByInstrumentsDeleteState")
    public LayuiDataTemplet<Instruments> updateByUserDeleteState(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (instruments.getVersion() != null && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        count = instrumentsService.updateByInstrumentsDeleteState(instruments.getIdlist());

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
     * @param instruments
     * @return
     *
     * @author ZY on 2019/03/12
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<Instruments> deleteByIdList(@RequestBody Instruments instruments) {
        LayuiDataTemplet<Instruments> returnData = new LayuiDataTemplet<Instruments>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (instruments.getVersion() != null && !instruments.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(instruments.getVersion(), Config.VERSION);
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
        count = instrumentsService.deleteByIdList(instruments.getIdlist());

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
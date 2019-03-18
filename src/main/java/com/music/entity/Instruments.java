package com.music.entity;

import java.util.Date;
import java.util.List;

public class Instruments {
    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getInsId() {
        return insId;
    }

    private String insId;

    private String insName;

    private Date insCreatetime;

    private String insCreatebyid;

    private Date insUpdatetime;

    private String insUpdatebyid;

    private Integer insIsdel;

    // 版本信息
    /**
     * 版本号
     */
    private String version;

    // 分页数据
    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

    /**
     * 每页的数据量
     */
    private Integer pagesize;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<String> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<String> idlist) {
        this.idlist = idlist;
    }
// 操作数据
    /**
     * 根据idlist删除信息时使用
     */
    private List<String> idlist;

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName == null ? null : insName.trim();
    }

    public Date getInsCreatetime() {
        return insCreatetime;
    }

    public void setInsCreatetime(Date insCreatetime) {
        this.insCreatetime = insCreatetime;
    }

    public String getInsCreatebyid() {
        return insCreatebyid;
    }

    public void setInsCreatebyid(String insCreatebyid) {
        this.insCreatebyid = insCreatebyid == null ? null : insCreatebyid.trim();
    }

    public Date getInsUpdatetime() {
        return insUpdatetime;
    }

    public void setInsUpdatetime(Date insUpdatetime) {
        this.insUpdatetime = insUpdatetime;
    }

    public String getInsUpdatebyid() {
        return insUpdatebyid;
    }

    public void setInsUpdatebyid(String insUpdatebyid) {
        this.insUpdatebyid = insUpdatebyid == null ? null : insUpdatebyid.trim();
    }

    public Integer getInsIsdel() {
        return insIsdel;
    }

    public void setInsIsdel(Integer insIsdel) {
        this.insIsdel = insIsdel;
    }
}
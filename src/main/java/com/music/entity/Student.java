package com.music.entity;

import java.util.Date;
import java.util.List;

public class Student {
    private String stuId;

    private String stuAccounts;

    private String stuPassword;

    private String stuName;

    private Integer stuSex;

    private String stuHeader;

    private String stuInstrumentsid;

    private String stuInstruments;

    private Integer stuExamination;

    private String stuTeacherid;

    private Date stuCreatetime;

    private String stuCreatebyid;

    private Date stuUpdatetime;

    private String stuUpdatebyid;

    private Integer stuIsdel;
    /**
     * 版本号
     */
    private String version;

    // 分页数据
    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

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

    /**
     * 每页的数据量
     */
    private Integer pagesize;

    // 操作数据
    /**
     * 根据idlist删除信息时使用
     */
    private List<String> idlist;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuAccounts() {
        return stuAccounts;
    }

    public void setStuAccounts(String stuAccounts) {
        this.stuAccounts = stuAccounts == null ? null : stuAccounts.trim();
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword == null ? null : stuPassword.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getStuSex() {
        return stuSex;
    }

    public void setStuSex(Integer stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuHeader() {
        return stuHeader;
    }

    public void setStuHeader(String stuHeader) {
        this.stuHeader = stuHeader == null ? null : stuHeader.trim();
    }

    public String getStuInstrumentsid() {
        return stuInstrumentsid;
    }

    public void setStuInstrumentsid(String stuInstrumentsid) {
        this.stuInstrumentsid = stuInstrumentsid == null ? null : stuInstrumentsid.trim();
    }

    public String getStuInstruments() {
        return stuInstruments;
    }

    public void setStuInstruments(String stuInstruments) {
        this.stuInstruments = stuInstruments == null ? null : stuInstruments.trim();
    }

    public Integer getStuExamination() {
        return stuExamination;
    }

    public void setStuExamination(Integer stuExamination) {
        this.stuExamination = stuExamination;
    }

    public String getStuTeacherid() {
        return stuTeacherid;
    }

    public void setStuTeacherid(String stuTeacherid) {
        this.stuTeacherid = stuTeacherid == null ? null : stuTeacherid.trim();
    }

    public Date getStuCreatetime() {
        return stuCreatetime;
    }

    public void setStuCreatetime(Date stuCreatetime) {
        this.stuCreatetime = stuCreatetime;
    }

    public String getStuCreatebyid() {
        return stuCreatebyid;
    }

    public void setStuCreatebyid(String stuCreatebyid) {
        this.stuCreatebyid = stuCreatebyid == null ? null : stuCreatebyid.trim();
    }

    public Date getStuUpdatetime() {
        return stuUpdatetime;
    }

    public void setStuUpdatetime(Date stuUpdatetime) {
        this.stuUpdatetime = stuUpdatetime;
    }

    public String getStuUpdatebyid() {
        return stuUpdatebyid;
    }

    public void setStuUpdatebyid(String stuUpdatebyid) {
        this.stuUpdatebyid = stuUpdatebyid == null ? null : stuUpdatebyid.trim();
    }

    public Integer getStuIsdel() {
        return stuIsdel;
    }

    public void setStuIsdel(Integer stuIsdel) {
        this.stuIsdel = stuIsdel;
    }
}
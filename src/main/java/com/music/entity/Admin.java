package com.music.entity;

import java.util.Date;
import java.util.List;

public class Admin {
    private String admId;

    private String admName;

    private String admAccounts;

    private String admPassword;

    private String admHeader;

    private Integer admIsroot;

    private Date admCreatetime;

    private String admCreatebyid;

    private Date admUpdatetime;

    private String admUpdatebyid;

    private Integer admIsdel;


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

    // 操作数据
    /**
     * 根据idlist删除信息时使用
     */
    private List<String> idlist;

    public Admin() {
    }

    public List<String> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<String> idlist) {
        this.idlist = idlist;
    }

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






    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId == null ? null : admId.trim();
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName == null ? null : admName.trim();
    }

    public String getAdmAccounts() {
        return admAccounts;
    }

    public void setAdmAccounts(String admAccounts) {
        this.admAccounts = admAccounts == null ? null : admAccounts.trim();
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword == null ? null : admPassword.trim();
    }

    public String getAdmHeader() {
        return admHeader;
    }

    public void setAdmHeader(String admHeader) {
        this.admHeader = admHeader == null ? null : admHeader.trim();
    }

    public Integer getAdmIsroot() {
        return admIsroot;
    }

    public void setAdmIsroot(Integer admIsroot) {
        this.admIsroot = admIsroot;
    }

    public Date getAdmCreatetime() {
        return admCreatetime;
    }

    public void setAdmCreatetime(Date admCreatetime) {
        this.admCreatetime = admCreatetime;
    }

    public String getAdmCreatebyid() {
        return admCreatebyid;
    }

    public void setAdmCreatebyid(String admCreatebyid) {
        this.admCreatebyid = admCreatebyid == null ? null : admCreatebyid.trim();
    }

    public Date getAdmUpdatetime() {
        return admUpdatetime;
    }

    public void setAdmUpdatetime(Date admUpdatetime) {
        this.admUpdatetime = admUpdatetime;
    }

    public String getAdmUpdatebyid() {
        return admUpdatebyid;
    }

    public void setAdmUpdatebyid(String admUpdatebyid) {
        this.admUpdatebyid = admUpdatebyid == null ? null : admUpdatebyid.trim();
    }

    public Integer getAdmIsdel() {
        return admIsdel;
    }

    public void setAdmIsdel(Integer admIsdel) {
        this.admIsdel = admIsdel;
    }
}
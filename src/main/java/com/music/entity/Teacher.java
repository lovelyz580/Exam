package com.music.entity;

import java.util.Date;

public class Teacher {
    private String teaId;

    private String teaName;

    private String teaAccounts;

    private String teaPassword;

    private Integer teaSex;

    private String teaHeader;

    private String teaInstrumentsid;

    private String teaInstruments;

    private Date teaCreatetime;

    private String teaCreatebyid;

    private Date teaUpdatetime;

    private String teaUpdatebyid;

    private Integer teaIsdel;

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId == null ? null : teaId.trim();
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaAccounts() {
        return teaAccounts;
    }

    public void setTeaAccounts(String teaAccounts) {
        this.teaAccounts = teaAccounts == null ? null : teaAccounts.trim();
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword == null ? null : teaPassword.trim();
    }

    public Integer getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(Integer teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaHeader() {
        return teaHeader;
    }

    public void setTeaHeader(String teaHeader) {
        this.teaHeader = teaHeader == null ? null : teaHeader.trim();
    }

    public String getTeaInstrumentsid() {
        return teaInstrumentsid;
    }

    public void setTeaInstrumentsid(String teaInstrumentsid) {
        this.teaInstrumentsid = teaInstrumentsid == null ? null : teaInstrumentsid.trim();
    }

    public String getTeaInstruments() {
        return teaInstruments;
    }

    public void setTeaInstruments(String teaInstruments) {
        this.teaInstruments = teaInstruments == null ? null : teaInstruments.trim();
    }

    public Date getTeaCreatetime() {
        return teaCreatetime;
    }

    public void setTeaCreatetime(Date teaCreatetime) {
        this.teaCreatetime = teaCreatetime;
    }

    public String getTeaCreatebyid() {
        return teaCreatebyid;
    }

    public void setTeaCreatebyid(String teaCreatebyid) {
        this.teaCreatebyid = teaCreatebyid == null ? null : teaCreatebyid.trim();
    }

    public Date getTeaUpdatetime() {
        return teaUpdatetime;
    }

    public void setTeaUpdatetime(Date teaUpdatetime) {
        this.teaUpdatetime = teaUpdatetime;
    }

    public String getTeaUpdatebyid() {
        return teaUpdatebyid;
    }

    public void setTeaUpdatebyid(String teaUpdatebyid) {
        this.teaUpdatebyid = teaUpdatebyid == null ? null : teaUpdatebyid.trim();
    }

    public Integer getTeaIsdel() {
        return teaIsdel;
    }

    public void setTeaIsdel(Integer teaIsdel) {
        this.teaIsdel = teaIsdel;
    }
}
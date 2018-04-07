package com.cf.bbackend.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 用户表
 */
@Entity
public class Consumer {
    @Id
    @GeneratedValue
    private Integer urid;       // 用户id
    private String urname;      // 用户昵称
    private String uricon;      // 用户头像
    private String urnum;       // 用户账号
    private String urpswd;      // 用户密码
    private String uremail;     // 用户邮箱
    private String urexplain;   // 用户简介

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }

    public String getUrname() {
        return urname;
    }

    public void setUrname(String urname) {
        this.urname = urname;
    }

    public String getUricon() {
        return uricon;
    }

    public void setUricon(String uricon) {
        this.uricon = uricon;
    }

    public String getUrnum() {
        return urnum;
    }

    public void setUrnum(String urnum) {
        this.urnum = urnum;
    }

    public String getUrpswd() {
        return urpswd;
    }

    public void setUrpswd(String urpswd) {
        this.urpswd = urpswd;
    }

    public String getUremail() {
        return uremail;
    }

    public void setUremail(String uremail) {
        this.uremail = uremail;
    }

    public String getUrexplain() {
        return urexplain;
    }

    public void setUrexplain(String urexplain) {
        this.urexplain = urexplain;
    }
}

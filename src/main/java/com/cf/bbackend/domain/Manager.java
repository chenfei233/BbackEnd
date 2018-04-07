package com.cf.bbackend.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 管理员表
 */
@Entity
public class Manager {

    @Id
    @GeneratedValue
    private Integer admid;   // 管理员id
    private String admname;  // 管理员姓名
    private String admicon;  // 管理员头像
    private String admnum;   // 管理员账号
    private String admpwd;   // 管理员密码

    public Manager() {
    }

    public Integer getAdmid() {
        return admid;
    }

    public void setAdmid(Integer admid) {
        this.admid = admid;
    }

    public String getAdmname() {
        return admname;
    }

    public void setAdmname(String admname) {
        this.admname = admname;
    }

    public String getAdmicon() {
        return admicon;
    }

    public void setAdmicon(String admicon) {
        this.admicon = admicon;
    }

    public String getAdmnum() {
        return admnum;
    }

    public void setAdmnum(String admnum) {
        this.admnum = admnum;
    }

    public String getAdmpwd() {
        return admpwd;
    }

    public void setAdmpwd(String admpwd) {
        this.admpwd = admpwd;
    }
}

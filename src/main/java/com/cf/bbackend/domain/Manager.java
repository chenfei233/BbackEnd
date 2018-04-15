package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 管理员表
 */
@Entity
@Data
public class Manager {

    /** 管理员id. */
    @Id
    @GeneratedValue
    private Integer admid;

    /** 管理员姓名. */
    private String admname;

    /** 管理员头像. */
    private String admicon;

    /** 管理员账号. */
    private String admnum;

    /** 管理员密码. */
    private String admpwd;

    public Manager(){}

    public Manager(String admname, String admicon, String admnum, String admpwd) {
        this.admname = admname;
        this.admicon = admicon;
        this.admnum = admnum;
        this.admpwd = admpwd;
    }
}

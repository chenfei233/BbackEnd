package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 用户表
 */
@Entity
@Data
public class Consumer {

    /** 用户id. */
    @Id
    @GeneratedValue
    private Integer urid;

    /** 用户昵称. */
    private String urname;

    /** 用户头像. */
    private String uricon;

    /** 用户账号. */
    private String urnum;

    /** 用户密码. */
    private String urpswd;

    /** 用户邮箱. */
    private String uremail;

    /** 用户简介. */
    private String urexplain;

    public Consumer() {
    }

    public Consumer(String urname, String uricon, String urnum, String urpswd, String uremail, String urexplain) {
        this.urname = urname;
        this.uricon = uricon;
        this.urnum = urnum;
        this.urpswd = urpswd;
        this.uremail = uremail;
        this.urexplain = urexplain;
    }
}

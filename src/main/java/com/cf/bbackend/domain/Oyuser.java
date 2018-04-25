package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 普通用户表oyuser
 */
@Entity
@Data
public class Oyuser {

    /** 用户id. */
    @Id
    @GeneratedValue
    private Integer oyid;

    /** 用户账号. */
    private String oynum;

    /** 用户昵称. */
    private String oyname;

    /** 用户密码. */
    private String oypswd;

    /** 用户头像. */
    private String oyicon;

    /** 用户邮箱. */
    private String oyemail;

    /** 用户简介. */
    private String oybrief;
}

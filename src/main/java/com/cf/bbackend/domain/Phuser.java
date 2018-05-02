package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 发布用户表phuser
 */
@Entity
@Data
public class Phuser {

    /** 用户id. */
    @Id
    @GeneratedValue
    private Integer phid;

    /** 用户账号. */
    private String phnum;

    /** 用户昵称. */
    private String phname;

    /** 用户密码. */
    private String phpswd;

    /** 用户头像. */
    private String phicon;

    /** 用户邮箱. */
    private String phemail;

    /** 用户简介. */
    private String phbrief;

    public Phuser() {
    }

    public Phuser(String phnum, String phname, String phpswd, String phicon, String phemail, String phbrief) {
        this.phnum = phnum;
        this.phname = phname;
        this.phpswd = phpswd;
        this.phicon = phicon;
        this.phemail = phemail;
        this.phbrief = phbrief;
    }
}

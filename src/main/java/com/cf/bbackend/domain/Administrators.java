package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 管理员表
 */
@Entity
@Data
public class Administrators {

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

}

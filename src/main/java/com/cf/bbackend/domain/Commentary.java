package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评论表commentary
 */
@Entity
@Data
public class Commentary {

    /** 评论id. */
    @Id
    @GeneratedValue
    private Integer cmtid;

    /** 评论内容. */
    private String cmtcontent;

    /** 评论时间. */
    private String cmttime;

    /** 文章id. */
    private Integer aieid;

    /** 普通用户id. */
    private Integer oyid;

    public Commentary() {
    }

    public Commentary(String cmtcontent, String cmttime, Integer aieid, Integer oyid) {
        this.cmtcontent = cmtcontent;
        this.cmttime = cmttime;
        this.aieid = aieid;
        this.oyid = oyid;
    }
}

package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评论表comment
 */
@Entity
@Data
public class Comment {

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
}

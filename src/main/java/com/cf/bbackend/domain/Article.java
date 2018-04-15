package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 文章表
 */
@Entity
@Data
public class Article {
    /** 文章id. */
    @Id
    @GeneratedValue
    private Integer aieid;

    /** 文章标题. */
    private String aietitle;

    /** 文章内容. */
    private String aiecontent;

    /** 首页图片. */
    private String aieimg;

    /** 发布时间. */
    private String aietime;

    /** 文章状态. */
    private String aiestate;

    /** 用户id. */
    private String userid;

    /** 类别id. */
    private String cgyid;

//    @JoinColumn(name = "urid")
//    @ManyToOne
//    private Consumer consumer;
//
//    @JoinColumn(name = "cgyid")
//    @ManyToOne
//    private Article article;


    public Article() {
    }

    public Article(String aietitle, String aiecontent, String aieimg, String aietime, String aiestate, String userid, String cgyid) {
        this.aietitle = aietitle;
        this.aiecontent = aiecontent;
        this.aieimg = aieimg;
        this.aietime = aietime;
        this.aiestate = aiestate;
        this.userid = userid;
        this.cgyid = cgyid;
    }
}

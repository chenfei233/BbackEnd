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

    /** 首页图片. */
    private String aieimg;

    /** 文章标题. */
    private String aietitle;

    /** 文章内容. */
    private String aiecontent;

    /** 文章状态. 0 1 -1 */
    private Integer aiestate;

    /** 发布时间. */
    private String aietime;

    /** 发布用户id. */
    private Integer phid;

    /** 类别id. */
    private Integer cgyid;

//    @JoinColumn(name = "urid")
//    @ManyToOne
//    private Consumer consumer;
//
//    @JoinColumn(name = "cgyid")
//    @ManyToOne
//    private Article article;


    public Article() {
    }

    public Article(String aieimg, String aietitle, String aiecontent, Integer aiestate, String aietime, Integer phid, Integer cgyid) {
        this.aieimg = aieimg;
        this.aietitle = aietitle;
        this.aiecontent = aiecontent;
        this.aiestate = aiestate;
        this.aietime = aietime;
        this.phid = phid;
        this.cgyid = cgyid;
    }
}

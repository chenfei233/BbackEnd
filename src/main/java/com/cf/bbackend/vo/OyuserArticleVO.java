package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 系统首页文章请求返回
 */
@Data
public class OyuserArticleVO {

    /** 文章id. */
    private Integer aieid;

    /** 首页图片. */
    private String aieimg;

    /** 文章标题. */
    private String aietitle;

    /** 发布时间. */
    private String aietime;

    /** 文章分类名称. */
    private String cgyname;

    /** 文章分类图片路径. */
    private String cgyicon;

    /** 评论数. */
    private int cmtnum;

    /** 收藏数. */
    private int cltnum;

}

package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 请求返回的文章对象
 */
@Data
public class ArticleVO {

    /** 文章ID. */
    private Integer aieid;

    /** 文章标题. */
    private String aietitle;

    /** 文章分类. */
    private String aiesort;

    /** 发布时间. */
    private String aietime;

    /** 文章状态. */
    private String aiestate;

    /** 发布用户. */
    private String urname;
}

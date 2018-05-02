package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 管理员首页文章请求返回
 */
@Data
public class AdminArticleVO {

    /** 文章ID. */
    private Integer aieid;

    /** 文章标题. */
    private String aietitle;

    /** 文章分类. */
    private String aiesort;

    /** 发布时间. */
    private String aietime;

    /** 文章状态. */
    private Integer aiestate;

    /** 发布用户. */
    private String urname;

}

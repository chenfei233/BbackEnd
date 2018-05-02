package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 请求返回
 *   管理员页面的文章对象信息
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
    private Integer aiestate;

    /** 发布用户. */
    private String urname;
}

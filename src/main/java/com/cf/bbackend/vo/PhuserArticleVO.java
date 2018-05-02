package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 发布员首页文章请求返回
 */
@Data
public class PhuserArticleVO {

    /** 文章ID. */
    private Integer aieid;

    /** 文章标题. */
    private String aietitle;

    /** 文章分类. */
    private String aiesort;

    /** 发布时间. */
    private String aietime;

}

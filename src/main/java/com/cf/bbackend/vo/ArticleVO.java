package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 请求返回
 *   文章对象详细信息
 */
@Data
public class ArticleVO {

    /** 文章ID. */
    private Integer aieid;

    /** 文章标题. */
    private String aietitle;

    /** 首页图片. */
    private String aieimg;

    /** 文章内容. */
    private String aiecontent;

    /** 文章分类名称. */
    private String cgyname;

    /** 文章分类图片路径. */
    private String cgyicon;

    /** 发布时间. */
    private String aietime;

    /** 发布用户昵称. */
    private String phname;

    /** 发布用户头像. */
    private String phicon;
}

package com.cf.bbackend.vo;

import lombok.Data;

/**
 * 请求返回
 *   评论信息列表
 */
@Data
public class CommentaryVO {

    /** 评论id. */
    private Integer cmtid;

    /** 评论内容. */
    private String cmtcontent;

    /** 评论时间. */
    private String cmttime;

    /** 用户昵称. */
    private String oyname;

    /** 用户头像. */
    private String oyicon;

}

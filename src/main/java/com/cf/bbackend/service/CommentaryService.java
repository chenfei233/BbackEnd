package com.cf.bbackend.service;

import com.cf.bbackend.domain.Commentary;

/**
 * 评论表
 */
public interface CommentaryService {

    /** 查询该文章下的评论数目 */
    int countByAieid(Integer Aieid);

    /** 该文章下的所有评论 */
    Commentary findByAieid(Integer Aieid);

    /** 添加评论 */
    Commentary addOrUpdata(Commentary comment);

}

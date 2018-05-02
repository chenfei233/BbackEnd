package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 评论表
 */
public interface CommentaryRepository extends JpaRepository<Commentary,Integer>{

    /** 该文章下的评论数目 */
    int countByAieid(Integer Aieid);

    /** 该文章下的所有评论 */
    Commentary findByAieid(Integer Aieid);

}

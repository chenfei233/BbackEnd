package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 评论表
 */
public interface CommentaryRepository extends JpaRepository<Commentary,Integer>{

    /** 该文章下的评论数目 */
    int countByAieid(Integer Aieid);

    /** 该文章下的所有评论 */
    List<Commentary> findByAieid(Integer Aieid);

}

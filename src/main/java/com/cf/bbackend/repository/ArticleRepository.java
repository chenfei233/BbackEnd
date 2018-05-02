package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 文章
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    /** 根据ID查询 */
    Article findByAieid(Integer aieId);

    /** 查询某状态下的全部文章 */
    List<Article> findByAiestate(Integer Aiestate);

    /** 查询某状态的全部文章数目 */
    int countByAiestate(Integer Aiestate);

    /** 查询某用户下的某状态的文章 */
    List<Article> findByPhidAndAiestate(Integer Phid,Integer Aiestate);

    /** 查询某发布用户的某个状态的文章数目 */
    int countByPhidAndAiestate(Integer Phid,Integer Aiestate);
}

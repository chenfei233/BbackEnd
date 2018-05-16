package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 文章
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

//    /** 删除文章 */
//    void deleteByAieid(Integer aieId);

    /** 根据ID查询 */
    Article findByAieid(Integer aieId);

    /** 查询某状态下的全部文章 */
    List<Article> findByAiestate(Integer Aiestate);

    /** 查询某状态的全部文章数目 */
    int countByAiestate(Integer Aiestate);

    /** 查询某用户下的某状态的文章 */
    List<Article> findByPhidAndAiestate(Integer Phid, Integer Aiestate);

    /** 查询某用户下的某状态的文章(分页) */
    Page<Article> findByPhidAndAiestate(Integer Phid, Integer Aiestate, Pageable pageable);

    /** 查询某发布用户的某个状态的文章数目 */
    int countByPhidAndAiestate(Integer Phid,Integer Aiestate);

}

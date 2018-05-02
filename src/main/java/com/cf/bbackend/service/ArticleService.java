package com.cf.bbackend.service;

import com.cf.bbackend.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 文章
 */
public interface ArticleService {

    /** 查询某一条. */
    Article findByAieid(Integer aieId);

    /** 添加/更新. */
    Article addOrUpdata(Article article);

    /** 查询某状态的全部文章 */
    List<Article> findByAiestate(Integer Aiestate);

    /** 查询某状态的全部文章数目 */
    int countByAiestate(Integer Aiestate);

    /** 查询某发布用户的某个状态的文章 */
    List<Article> findByPhidAndAiestate(Integer Phid,Integer Aiestate);

    /** 查询某发布用户的某个状态的文章数目 */
    int countByPhidAndAiestate(Integer Phid,Integer Aiestate);

//    /** 用户查询所有的. */
//    List<Article> userFindAll();

//    /** 管理员分页查询 所有的. */
//    Page<Article> adminFindAll(Pageable pageable);

//    /** 添加/更新. */
//    Article addOrUpdata(Article article);

//    /** 管理员查询待审核的 */
//    List<Article> findByAll();

}

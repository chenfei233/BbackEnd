package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文章
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    /** 根据ID查询 */
    Article findByAieid(Integer aieId);
}

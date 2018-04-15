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

    /** 用户查询所有的. */
    List<Article> userFindAll();

    /** 管理员分页查询 所有的. */
    Page<Article> adminFindAll(Pageable pageable);

    /** 添加/更新. */
    Article addOrUpdata(Article article);

}

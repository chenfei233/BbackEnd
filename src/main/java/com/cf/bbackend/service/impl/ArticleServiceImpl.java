package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.repository.ArticleRepository;
import com.cf.bbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article findByAieid(Integer aieId) {
        return articleRepository.findByAieid(aieId);
    }

    @Override
    public List<Article> userFindAll() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> adminFindAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article addOrUpdata(Article article) {
        return articleRepository.save(article);
    }
}

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
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public int countAll() {
        return (int)articleRepository.count();
    }

    @Override
    public Article findByAieid(Integer aieId) {
        return articleRepository.findByAieid(aieId);
    }

    @Override
    public Article addOrUpdata(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findByAiestate(Integer Aiestate) {
        return articleRepository.findByAiestate(Aiestate);
    }

    @Override
    public int countByAiestate(Integer Aiestate) {
        return articleRepository.countByAiestate(Aiestate);
    }

    @Override
    public List<Article> findByPhidAndAiestate(Integer Phid, Integer Aiestate) {
//        Page<Article> articlePage=articleRepository.findByPhidAndAiestate(Phid,Aiestate,pageable);
        return articleRepository.findByPhidAndAiestate(Phid,Aiestate);
    }

    @Override
    public int countByPhidAndAiestate(Integer Phid, Integer Aiestate) {
        return articleRepository.countByPhidAndAiestate(Phid,Aiestate);
    }

}

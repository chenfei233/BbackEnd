package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.repository.ArticleRepository;
import com.cf.bbackend.service.ArticleService;
import org.springframework.beans.BeanUtils;
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
    public void deleteByAieid(Integer aieId) {
        articleRepository.deleteById(aieId);
    }

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
    public int countByAiestateAndCgyid(Integer Aiestate, Integer Cgyid) {
        return articleRepository.countByAiestateAndCgyid(Aiestate,Cgyid);
    }

    @Override
    public List<Article> findByAiestateAndCgyid(Integer Aiestate, Integer Cgyid) {
        return articleRepository.findByAiestateAndCgyid(Aiestate,Cgyid);
    }

    @Override
    public Page<Article> findByPhidAndAiestate(Integer Phid, Integer Aiestate,Pageable pageable) {
        Page<Article> pageArticle=articleRepository.findByPhidAndAiestate(Phid,Aiestate,pageable);
        System.out.println("分页测试0："+pageArticle.getContent());
        System.out.println("分页测试1："+pageArticle.getTotalElements());
        return articleRepository.findByPhidAndAiestate(Phid,Aiestate,pageable);
//        return articlePage;
//        List<Article> orderDTOList = convert(articlePage.getContent());
//
//        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public int countByPhidAndAiestate(Integer Phid, Integer Aiestate) {
        return articleRepository.countByPhidAndAiestate(Phid,Aiestate);
    }

    public Article convert(Article article) {
        Article art = new Article();
        BeanUtils.copyProperties(article, art);
        return art;
    }

}

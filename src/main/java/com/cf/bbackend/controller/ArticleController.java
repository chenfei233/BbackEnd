package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.service.ArticleService;
import com.cf.bbackend.service.CategoryService;
import com.cf.bbackend.service.ConsumerService;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.ArticleVO;
import com.cf.bbackend.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章操作
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final static Logger logger= LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService  articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/list")
    public ResultVO list(){
        List<Article> articleList=articleService.userFindAll();
        List<ArticleVO> articleVOList=new ArrayList<>();
        for (Article article:articleList){
            ArticleVO articleVO=new ArticleVO();
            articleVO.setAieid(article.getAieid());
            articleVO.setAietitle(article.getAietitle());
            articleVO.setAiesort(categoryService.findByCgyid(Integer.parseInt(article.getCgyid())).getCgyname());
            articleVO.setAietime(article.getAietime());
            articleVO.setAiestate(article.getAiestate());
            articleVO.setUrname(consumerService.findByUrid(Integer.parseInt(article.getUserid())).getUrname());
            articleVOList.add(articleVO);
        }
//        ResultVO resultVO=new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setCount(1000);
//        resultVO.setMsg("成功");
//        resultVO.setData(articleVOList);
//        resultVO.setData(Arrays.asList(articleRepository.findAll()));
//        resultVO.setData(articleService.userFindAll());
        return ResultVOUtils.success(articleVOList,100);
    }

    /**
     *
     * @return
     */
    public List<Article> articleList(){
        return articleService.userFindAll();
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    @PostMapping(value = "/addArticle")
    public Article addArticle(Article article){
        article.setAietitle(article.getAietitle());
        article.setAiecontent(article.getAiecontent());
        article.setAieimg(article.getAieimg());
        article.setAiestate("待审核");
        article.setUserid(article.getUserid());
        article.setCgyid(article.getCgyid());
        return articleService.addOrUpdata(article);
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    public Article updataArticle(Article article){
        article.setAieid(article.getAieid());
        article.setAietitle(article.getAietitle());
        article.setAiecontent(article.getAiecontent());
        article.setAieimg(article.getAieimg());
        article.setAiestate("待审核");
        article.setUserid(article.getUserid());
        article.setCgyid(article.getCgyid());
        return articleService.addOrUpdata(article);
    }
}

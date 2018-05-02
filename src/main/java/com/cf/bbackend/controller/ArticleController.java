package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.service.ArticleService;
import com.cf.bbackend.service.CategoryService;
import com.cf.bbackend.service.ConsumerService;
import com.cf.bbackend.service.PhuserService;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.AdminArticleVO;
import com.cf.bbackend.vo.ArticleVO;
import com.cf.bbackend.vo.PhuserArticleVO;
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
@RequestMapping("/Article")
public class ArticleController {

    private final static Logger logger= LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService  articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PhuserService phuserService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @PostMapping(value = "/addArticle")
    public Article addArticle(Article article){
        return articleService.addOrUpdata(article);
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    @PostMapping(value = "/updataArticle")
    public Article updataArticle(Article article){
        return articleService.addOrUpdata(article);
    }

    /**
     * 查询某篇文章
     * @param article
     * @return
     */
    @PostMapping(value = "/findByAieid")
    public Article findByAieid(Article article){
        return articleService.findByAieid(article.getAieid());
    }

    /**
     * 管理员 查询某状态的全部文章
     * @param article
     * @return
     */
    @PostMapping(value = "/findByAiestate")
    public ResultVO findByAiestate(Article article){
        int count=articleService.countByAiestate(article.getAiestate());
        List<Article> articleList=articleService.findByAiestate(article.getAiestate());
        List<AdminArticleVO> AdminArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            AdminArticleVO adminArticleVO=new AdminArticleVO();
            adminArticleVO.setAieid(a.getAieid());
            adminArticleVO.setAietitle(a.getAietitle());
            adminArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            adminArticleVO.setAietime(a.getAietime());
            adminArticleVO.setAiestate(a.getAiestate());
            adminArticleVO.setUrname(phuserService.findByPhid(a.getPhid()).getPhnum());
            AdminArticleVOList.add(adminArticleVO);
        }
        return ResultVOUtils.success(AdminArticleVOList,count);
    }

    /**
     * 某发布用户下某状态全部文章
     * @param article
     * @return
     */
    @PostMapping(value = "/findByPhidAndAiestate")
    public ResultVO findByPhidAndAiestate(Article article){
        int count=articleService.countByPhidAndAiestate(article.getPhid(),article.getAiestate());
        List<Article> articleList=articleService.findByPhidAndAiestate(article.getPhid(),article.getAiestate());
        List<PhuserArticleVO> PhuserArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            PhuserArticleVO phuserArticleVO=new PhuserArticleVO();
            phuserArticleVO.setAieid(a.getAieid());
            phuserArticleVO.setAietitle(a.getAietitle());
            phuserArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            phuserArticleVO.setAietime(a.getAietime());
            PhuserArticleVOList.add(phuserArticleVO);
        }
        return ResultVOUtils.success(PhuserArticleVOList,count);
    }

//    @GetMapping("/articleList")
//    public ResultVO list(){
//        List<Article> articleList=articleService.userFindAll();
//        List<ArticleVO> articleVOList=new ArrayList<>();
//        for (Article article:articleList){
//            ArticleVO articleVO=new ArticleVO();
//            articleVO.setAieid(article.getAieid());
//            articleVO.setAietitle(article.getAietitle());
//            articleVO.setAiesort(categoryService.findByCgyid(Integer.parseInt(article.getCgyid())).getCgyname());
//            articleVO.setAietime(article.getAietime());
//            articleVO.setAiestate(article.getAiestate());
//            articleVO.setUrname(consumerService.findByUrid(Integer.parseInt(article.getUserid())).getUrname());
//            articleVOList.add(articleVO);
//        }
//        ResultVO resultVO=new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setCount(1000);
//        resultVO.setMsg("成功");
//        resultVO.setData(articleVOList);
//        resultVO.setData(Arrays.asList(articleRepository.findAll()));
//        resultVO.setData(articleService.userFindAll());
//        return ResultVOUtils.success(articleVOList,100);
//    }
}

package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.domain.Category;
import com.cf.bbackend.domain.Collect;
import com.cf.bbackend.service.*;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.OyuserArticleVO;
import com.cf.bbackend.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏操作
 */
@RestController
@RequestMapping("/Collect")
public class CollectController {

    private final static Logger logger= LoggerFactory.getLogger(CollectController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private CollectService collectService;

    /**
     * 收藏操作
     *   该用户存在改文章收藏，则删除，否则添加收藏
     * @param collect
     */
    @PostMapping(value = "/collectOperation")
    public int collectOperation(Collect collect){
        List<Collect> collectList=collectService.findByOyidAndAieid(collect.getOyid(),collect.getAieid());
        logger.info("收藏查询信息："+collectList.toString());
        if(collectList.size() > 0){
            collectService.deleteByCltid(collectList.get(0).getCltid());
            return -1;
        }else{
            collectService.addOrUpdata(collect);
            return 1;
        }
    }

    /**
     * 根据文章id删除收藏
     * @param collect
     */
    @GetMapping(value = "/deleteByAieid")
    public void deleteByAieid(Collect collect){
        collectService.deleteByAieid(collect.getAieid());
    }

    /**
     * 根据用户id、文章id删除收藏
     * @param collect
     */
    @GetMapping(value = "/deleteByOyidAndAieid")
    public void deleteByOyidAndAieid(Collect collect){
        collectService.deleteByOyidAndAieid(collect.getOyid(),collect.getAieid());
    }

    /**
     * 显示用户收藏文章
     * @param collect
     * @return
     */
    @GetMapping(value = "/collectArticle")
    public ResultVO collectArticle(Collect collect){
        int count=collectService.countByOyid(collect.getOyid());
        List<Collect> collectList=collectService.findByOyid(collect.getOyid());
        List<OyuserArticleVO> oyuserArticleVOList=new ArrayList<>();
        for (Collect c:collectList){
            OyuserArticleVO oyuserArticleVO=new OyuserArticleVO();
            Article article=articleService.findByAieid(c.getAieid());
            Category category=categoryService.findByCgyid(article.getCgyid());

            oyuserArticleVO.setAieid(article.getAieid());
            oyuserArticleVO.setAieimg(article.getAieimg());
            oyuserArticleVO.setAietitle(article.getAietitle());
            oyuserArticleVO.setAietime(article.getAietime());
            oyuserArticleVO.setCgyicon(category.getCgyicon());
            oyuserArticleVO.setCgyname(category.getCgyname());
            oyuserArticleVO.setCmtnum(commentaryService.countByAieid(c.getAieid()));//评论数
            oyuserArticleVO.setCltnum(collectService.countByAieid(c.getAieid()));//收藏数
            oyuserArticleVOList.add(oyuserArticleVO);
        }
        return ResultVOUtils.success(oyuserArticleVOList,count);
    }
}

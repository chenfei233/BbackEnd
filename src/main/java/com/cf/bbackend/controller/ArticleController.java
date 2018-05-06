package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.service.ArticleService;
import com.cf.bbackend.service.CategoryService;
import com.cf.bbackend.service.PhuserService;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.AdminArticleVO;
import com.cf.bbackend.vo.PhuserArticleVO;
import com.cf.bbackend.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     * 管理员 查询全部文章
     * @return
     */
    @GetMapping(value = "/findAll")
    public ResultVO<Article> findAll(){
        int count=articleService.countAll();
        List<Article> articleList=articleService.findAll();
        List<AdminArticleVO> AdminArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            AdminArticleVO adminArticleVO=new AdminArticleVO();
            adminArticleVO.setAieid(a.getAieid());
            adminArticleVO.setAietitle(a.getAietitle());
            adminArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            adminArticleVO.setAietime(a.getAietime());
            adminArticleVO.setAiestate(getAiestate(a.getAiestate()));
            adminArticleVO.setUrname(phuserService.findByPhid(a.getPhid()).getPhname());
            AdminArticleVOList.add(adminArticleVO);
        }
        return ResultVOUtils.success(AdminArticleVOList,count);
    }

    /**
     * 添加一篇文章
     * @param article
     * @return
     */
    @PostMapping(value = "/addArticle")
    public Article addArticle(Article article){
        article.setAietime(currentTime());//文章发布时间
        article.setAiestate(0);//初始文章状态
        return articleService.addOrUpdata(article);
    }

    /**
     * 修改某篇文章
     * @param article
     * @return
     */
    @PostMapping(value = "/updataArticle")
    public Article updataArticle(Article article){
        article.setAietime(currentTime());//修改文章发布时间
        //article.setAiestate(0);//修改文章状态（前台传值吧）
        return articleService.addOrUpdata(article);
    }

    /**
     * 查询某篇文章
     * @param article
     * @return
     */
    @GetMapping(value = "/findByAieid")
    public Article findByAieid(Article article){
        return articleService.findByAieid(article.getAieid());
    }

    /**
     * 管理员 查询某状态的全部文章
     * @param article
     * @return
     */
    @GetMapping(value = "/findByAiestate")
    public ResultVO findByAiestate(Article article){
//        logger.info(article.getAiestate()+"=============");
        int count=articleService.countByAiestate(article.getAiestate());
        List<Article> articleList=articleService.findByAiestate(article.getAiestate());
        List<AdminArticleVO> AdminArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            AdminArticleVO adminArticleVO=new AdminArticleVO();
            adminArticleVO.setAieid(a.getAieid());
            adminArticleVO.setAietitle(a.getAietitle());
            adminArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            adminArticleVO.setAietime(a.getAietime());
            adminArticleVO.setAiestate(getAiestate(a.getAiestate()));
            adminArticleVO.setUrname(phuserService.findByPhid(a.getPhid()).getPhname());
            AdminArticleVOList.add(adminArticleVO);
        }
        return ResultVOUtils.success(AdminArticleVOList,count);
    }

    /**
     * 某发布用户下某状态全部文章
     * @param article
     * @return
     */
    @GetMapping(value = "/findByPhidAndAiestate")
    public ResultVO findByPhidAndAiestate(Article article,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){

        logger.info("当前第几页："+page);
        logger.info("页面数大小："+limit);

        PageRequest pageRequest=new PageRequest(page-1,limit);

        int count=articleService.countByPhidAndAiestate(article.getPhid(),article.getAiestate());
        List<Article> articleList=articleService.findByPhidAndAiestate(article.getPhid(),article.getAiestate());
        List<PhuserArticleVO> phuserArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            PhuserArticleVO phuserArticleVO=new PhuserArticleVO();
            phuserArticleVO.setAieid(a.getAieid());
            phuserArticleVO.setAietitle(a.getAietitle());
            phuserArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            phuserArticleVO.setAietime(a.getAietime());
            phuserArticleVOList.add(phuserArticleVO);
        }
        return ResultVOUtils.success(phuserArticleVOList,count);
    }

    public String getAiestate(int aiestate){//文章状态处理
        String str="状态出错";

        if (aiestate > 0){
            str="已通过";
        }else if (aiestate < 0){
            str="被驳回";
        }else {
            str="待审核";
        }
        return str;
    }

    public String currentTime(){//获取当前时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
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

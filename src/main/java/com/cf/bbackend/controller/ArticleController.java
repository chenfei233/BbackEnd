package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Article;
import com.cf.bbackend.domain.Category;
import com.cf.bbackend.domain.Collect;
import com.cf.bbackend.domain.Phuser;
import com.cf.bbackend.repository.ArticleRepository;
import com.cf.bbackend.service.*;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private CollectService collectService;

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
     * 删除文章
     * @param article
     */
    @GetMapping(value = "/deleteByAieid")
    public void deleteByAieid(Article article){
        articleService.deleteByAieid(article.getAieid());
    }

    /**
     * 修改某篇文章信息
     * @param article
     * @return   ###用不到了吧
     */
    @PostMapping(value = "/updataArticle")
    public Article updataArticle(Article article){
        logger.info("修改某篇文章信息:updataArticle  ");
        article.setAietime(currentTime());//修改文章发布时间
        Article a=articleService.findByAieid(article.getAieid());
        if(a.getAiestate() > 0){
            logger.info("修改的已发布文章，需要删除collect表中相应数据");
            List<Collect> collectList=collectService.findByAieid(article.getAieid());
            for (int i=0; i < collectList.size(); i++){
                collectService.deleteByCltid(collectList.get(i).getCltid());
            }
        }
        //article.setAiestate(0);//修改文章状态（前台传值吧）
        return articleService.addOrUpdata(article);
    }

    /**
     * 修改某篇文章状态
     * @param article
     * @return
     */
    @PostMapping(value = "/updataArticleAiestate")
    public Article updataArticleAiestate(Article article){
        logger.info("修改某篇文章状态");
        Article art=new Article();
        art=articleService.findByAieid(article.getAieid());
        art.setAiestate(article.getAiestate());

        if(art.getAiestate() > 0){
            logger.info("修改的已发布文章状态，需要删除collect表中相应数据");
            List<Collect> collectList=collectService.findByAieid(article.getAieid());
            for (int i=0; i < collectList.size(); i++){
                collectService.deleteByCltid(collectList.get(i).getCltid());
            }
        }

        return articleService.addOrUpdata(art);
//        articleService.updateAiestate(article.getAiestate(),article.getAieid());
    }

    /**
     * 查询某篇文章
     * @param article
     * @return
     */
    @GetMapping(value = "/findByAieid")
    public ArticleVO findByAieid(Article article){

        logger.info("findByAieid     查询某篇文章");

        Article aie = articleService.findByAieid(article.getAieid());
        Phuser phuser = phuserService.findByPhid(aie.getPhid());
        Category category = categoryService.findByCgyid(aie.getCgyid());

        ArticleVO articleVO=new ArticleVO();
        articleVO.setAieid(aie.getAieid());
        articleVO.setAietitle(aie.getAietitle());
        articleVO.setAieimg(aie.getAieimg());
        articleVO.setAiecontent(aie.getAiecontent());
        articleVO.setAietime(aie.getAietime());
        articleVO.setCgyname(category.getCgyname());
        articleVO.setCgyicon(category.getCgyicon());
        articleVO.setPhname(phuser.getPhname());
        articleVO.setPhicon(phuser.getPhicon());

        return articleVO;
    }

    /**
     * 管理员 查询全部文章
     * @return
     */
    @GetMapping(value = "/findAll")
    public ResultVO<Article> findAll(){
        int count=articleService.countAll();
        List<Article> articleList=articleService.findAll();
        List<AdminArticleVO> adminArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            AdminArticleVO adminArticleVO=new AdminArticleVO();
            adminArticleVO.setAieid(a.getAieid());
            adminArticleVO.setAietitle(a.getAietitle());
            adminArticleVO.setAiesort(categoryService.findByCgyid(a.getCgyid()).getCgyname());
            adminArticleVO.setAietime(a.getAietime());
            adminArticleVO.setAiestate(getAiestate(a.getAiestate()));
            adminArticleVO.setUrname(phuserService.findByPhid(a.getPhid()).getPhname());
            adminArticleVOList.add(adminArticleVO);
        }
        return ResultVOUtils.success(adminArticleVOList,count);
    }

    /**
     * 管理员 查询某状态的全部文章
     * @param article
     * @return
     */
    @GetMapping(value = "/findByAiestate")
    public ResultVO findByAiestate(Article article,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        logger.info(article.getAiestate()+"=============");

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

        PageRequest pageRequest=new PageRequest(page,limit);

        int count=articleService.countByPhidAndAiestate(article.getPhid(),article.getAiestate());
        List<Article> articleList=articleService.findByPhidAndAiestate(article.getPhid(),article.getAiestate());

//        logger.info("当前第几页article.getAiestate()："+article.getPhid());
//        logger.info("页面数大小article.getAiestate()："+article.getAiestate());

//        Page<Article> articleListText=articleService.findByPhidAndAiestate(article.getPhid(),article.getAiestate(),pageRequest);
//        System.out.println("分页测试0："+articleListText.getContent());
//        System.out.println("分页测试1："+articleListText.getTotalElements());

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

    /**
     * 系统首页文章的请求
     * @param article
     * @return
     */
    @GetMapping(value = "/indexArticle")
    public ResultVO indexArticle(Article article){
        article.setAiestate(1);
        int count=articleService.countByAiestate(article.getAiestate());
        List<Article> articleList=articleService.findByAiestate(article.getAiestate());
        List<OyuserArticleVO> oyuserArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            OyuserArticleVO oyuserArticleVO=new OyuserArticleVO();
            Category c=categoryService.findByCgyid(a.getCgyid());

            oyuserArticleVO.setAieid(a.getAieid());
            oyuserArticleVO.setAieimg(a.getAieimg());
            oyuserArticleVO.setAietitle(a.getAietitle());
            oyuserArticleVO.setAietime(a.getAietime());
            oyuserArticleVO.setCgyicon(c.getCgyicon());
            oyuserArticleVO.setCgyname(c.getCgyname());
            oyuserArticleVO.setCmtnum(commentaryService.countByAieid(a.getAieid()));//评论数
            oyuserArticleVO.setCltnum(collectService.countByAieid(a.getAieid()));//收藏数
            oyuserArticleVOList.add(oyuserArticleVO);
        }
        return ResultVOUtils.success(oyuserArticleVOList,count);
    }

    /**
     * 系统首页
     *      文章分类搜索的请求
     * @param article
     * @return
     */
    @GetMapping(value = "/indexArticleClassify")
    public ResultVO indexArticleClassify(Article article){
        article.setAiestate(1);
        int count=articleService.countByAiestateAndCgyid(article.getAiestate(),article.getCgyid());
        List<Article> articleList=articleService.findByAiestateAndCgyid(article.getAiestate(),article.getCgyid());
        List<OyuserArticleVO> oyuserArticleVOList=new ArrayList<>();
        for (Article a:articleList){
            OyuserArticleVO oyuserArticleVO=new OyuserArticleVO();
            Category c=categoryService.findByCgyid(a.getCgyid());

            oyuserArticleVO.setAieid(a.getAieid());
            oyuserArticleVO.setAieimg(a.getAieimg());
            oyuserArticleVO.setAietitle(a.getAietitle());
            oyuserArticleVO.setAietime(a.getAietime());
            oyuserArticleVO.setCgyicon(c.getCgyicon());
            oyuserArticleVO.setCgyname(c.getCgyname());
            oyuserArticleVO.setCmtnum(commentaryService.countByAieid(a.getAieid()));//评论数
            oyuserArticleVO.setCltnum(collectService.countByAieid(a.getAieid()));//收藏数
            oyuserArticleVOList.add(oyuserArticleVO);
        }
        return ResultVOUtils.success(oyuserArticleVOList,count);
    }

    /**
     * 文章状态处理
     * @param aiestate
     * @return
     */
    public String getAiestate(int aiestate){
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

    /**
     * 获取当前时间
     * @return
     */
    public String currentTime(){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

}

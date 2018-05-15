package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Commentary;
import com.cf.bbackend.domain.Oyuser;
import com.cf.bbackend.service.CommentaryService;
import com.cf.bbackend.service.OyuserService;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.CommentaryVO;
import com.cf.bbackend.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论操作
 */
@RestController
@RequestMapping("/Commentary")
public class CommentaryController {

    private final static Logger logger= LoggerFactory.getLogger(CommentaryController.class);

    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private OyuserService oyuserService;

    /**
     * 添加评论
     * @param commentary
     * @return
     */
    @PostMapping(value = "/addOrUpdata")
    public Commentary addOrUpdata(Commentary commentary){
        logger.info("添加评论");
        commentary.setCmttime(currentTime());
        return commentaryService.addOrUpdata(commentary);
    }

    /**
     * 该文章下的所有评论
     * @return
     */
    @GetMapping(value = "/findByAieid")
    public ResultVO<Commentary> findByAieid(Commentary commentary){
        logger.info("该文章下的所有评论");
        int count=commentaryService.countByAieid(commentary.getAieid());
        List<Commentary> commentaryList=commentaryService.findByAieid(commentary.getAieid());
        List<CommentaryVO> commentaryVOList=new ArrayList<> ();
        for (Commentary c:commentaryList){
            CommentaryVO commentaryVO=new CommentaryVO();
            Oyuser oyuser=oyuserService.findByOyid(c.getOyid());
            commentaryVO.setCmtid(c.getCmtid());
            commentaryVO.setCmtcontent(c.getCmtcontent());
            commentaryVO.setCmttime(c.getCmttime());
//            logger.info("oyuser.getOyname():::"+oyuser.getOyname());
            commentaryVO.setOyname(oyuser.getOyname());
            commentaryVO.setOyicon(oyuser.getOyicon());
            commentaryVOList.add(commentaryVO);
        }
        return ResultVOUtils.success(commentaryVOList,count);
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

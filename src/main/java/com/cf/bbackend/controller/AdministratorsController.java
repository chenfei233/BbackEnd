package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Administrators;
import com.cf.bbackend.domain.Article;
import com.cf.bbackend.service.AdministratorsService;
import com.cf.bbackend.service.ArticleService;
import com.cf.bbackend.utils.ResultVOUtils;
import com.cf.bbackend.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员操作
 */
@RestController
@RequestMapping("/Admin")
public class AdministratorsController {

    private final static Logger logger= LoggerFactory.getLogger(AdministratorsController.class);

    @Autowired
    private AdministratorsService administratorsService;

    @Autowired
    private ArticleService articleService;

    /**
     * 管理员登录
     * @param administrators
     * @return
     */
    @PostMapping(value = "/adminLogin")
    public ResultVO adminLogin(Administrators administrators){
        Administrators admin = new Administrators();
        admin=administratorsService.findByAdmnumAndAdmpwd(administrators.getAdmnum(),administrators.getAdmpwd());
        if(admin == null){
            return ResultVOUtils.error(1,"错误",0);
        }else {
            return ResultVOUtils.success(admin, 1);
        }
    }

    /**
     * 管理员注册
     * @param administrators
     * @return
     */
    @PostMapping(value = "/addAdmin")
    public Administrators addAdmin(Administrators administrators){
        if(administratorsService.findByAdmnum(administrators.getAdmnum()) == null){
            logger.info("注册账号："+administrators.getAdmnum()+"成功！");
            return administratorsService.addOrUpdata(administrators);
        }else{
            logger.info("用户账号："+administrators.getAdmnum()+"存在！");
            return administratorsService.findByAdmnum("");
        }
    }

    /**
     * 管理员修改信息
     * @param administrators
     * @return
     */
    @PostMapping(value = "/updataAdmin")
    public ResultVO updataAdmin(Administrators administrators){
        return ResultVOUtils.success(administratorsService.addOrUpdata(administrators),1);
    }
//    public Administrators updataAdmin(Administrators administrators){
//        return administratorsService.addOrUpdata(administrators);
//    }

    /** 待定 参数什么都是错的 */
    public ResultVO articleList(Administrators administrators){
//        List<Article> articleList=articleService;
        return ResultVOUtils.success(administrators,100);
    }
}

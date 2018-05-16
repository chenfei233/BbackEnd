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

    /**
     * 更新个人头像信息
     * @param administrators
     * @return
     */
    @PostMapping(value = "/updataAdminIcon")
    public Administrators updataAdminIcon(Administrators administrators){
        logger.info("更新个人头像信息");
        Administrators admin=administratorsService.findByAdmid(administrators.getAdmid());
        admin.setAdmicon(administrators.getAdmicon());
        return administratorsService.addOrUpdata(admin);
    }

    /**
     * 更新昵称
     * @param administrators
     * @return
     */
    @PostMapping(value = "/updataAdminInfo")
    public Administrators updataAdminInfo(Administrators administrators){
        logger.info("更新昵称");
        Administrators admin=administratorsService.findByAdmid(administrators.getAdmid());
        admin.setAdmname(administrators.getAdmname());
        return administratorsService.addOrUpdata(admin);
    }

    /**
     * 根据id、密码查询
     * @param administrators
     * @return
     */
    @PostMapping(value = "/findByAdmidAndAdmpwd")
    public Administrators findByAdmidAndAdmpwd(Administrators administrators){
        logger.info("根据id、密码查询");
        return administratorsService.findByAdmidAndAdmpwd(administrators.getAdmid(),administrators.getAdmpwd());
    }

    /**
     * 更新密码
     * @param administrators
     * @return
     */
    @PostMapping(value = "/updataAdminPswd")
    public Administrators updataAdminPswd(Administrators administrators){
        logger.info("更新密码");
        Administrators admin=administratorsService.findByAdmid(administrators.getAdmid());
        admin.setAdmpwd(administrators.getAdmpwd());
        return administratorsService.addOrUpdata(admin);
    }

}

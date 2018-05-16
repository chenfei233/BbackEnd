package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Phuser;
import com.cf.bbackend.service.PhuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布用户操作
 */
@RestController
@RequestMapping("/Phuser")
public class PhuserController {

    private final static Logger logger= LoggerFactory.getLogger(PhuserController.class);

    @Autowired
    private PhuserService phuserService;

    /**
     * 发布用户登录
     * @param phuser
     * @return
     */
    @PostMapping(value = "/phuserLogin")
    public Phuser phuserLogin(Phuser phuser){
        return phuserService.findByPhnumAndPhpswd(phuser.getPhnum(),phuser.getPhpswd());
    }

    /**
     * 发布用户注册
     * @param phuser
     * @return
     */
    @PostMapping(value = "/addPhuser")
    public Phuser addPhuser(Phuser phuser){
        if (phuserService.findByPhnum(phuser.getPhnum()) == null) {
            logger.info("发布用户："+phuser.getPhnum()+"注册成功！");
            return phuserService.addOrUpdata(phuser);
        }else{
            logger.info("发布用户："+phuser.getPhnum()+"已存在！");
            return phuserService.findByPhnum("");
        }
    }

    /**
     * 发布用户修改个人信息
     * @param phuser
     * @return
     */
    @PostMapping(value = "/updataPhuser")
    public Phuser updataPhuser(Phuser phuser){
        return phuserService.addOrUpdata(phuser);
    }

    /**
     * 更新个人头像信息
     * @param phuser
     * @return
     */
    @PostMapping(value = "/updataPhuserIcon")
    public Phuser updataPhuserIcon(Phuser phuser){
        Phuser p=phuserService.findByPhid(phuser.getPhid());
        p.setPhicon(phuser.getPhicon());
        return phuserService.addOrUpdata(p);
    }

    /**
     * 普通用户更新个人信息(昵称、简介、邮箱)
     * @param phuser
     * @return
     */
    @PostMapping(value = "/updataPhuserInfo")
    public Phuser updataPhuserInfo(Phuser phuser){
        Phuser p=phuserService.findByPhid(phuser.getPhid());
        p.setPhname(phuser.getPhname());
        p.setPhemail(phuser.getPhemail());
        p.setPhbrief(phuser.getPhbrief());
        return phuserService.addOrUpdata(p);
    }

    /**
     * 根据id、密码查询
     * @param phuser
     * @return
     */
    @PostMapping(value = "/findByPhidAndAndPhpswd")
    public Phuser findByPhidAndAndPhpswd(Phuser phuser){
        return phuserService.findByPhidAndAndPhpswd(phuser.getPhid(),phuser.getPhpswd());
    }

    /**
     * 用户更新密码
     * @param phuser
     * @return
     */
    @PostMapping(value = "/updataPhuserPswd")
    public Phuser updataPhuserPswd(Phuser phuser){
        Phuser p=phuserService.findByPhid(phuser.getPhid());
        p.setPhpswd(phuser.getPhpswd());
        return phuserService.addOrUpdata(p);
    }

}

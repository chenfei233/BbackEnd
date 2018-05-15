package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Oyuser;
import com.cf.bbackend.service.OyuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通用户操作
 */
@RestController
@RequestMapping("/Oyuser")
public class OyuserController {

    private final static Logger logger= LoggerFactory.getLogger(OyuserController.class);

    @Autowired
    private OyuserService oyuserService;

    /**
     * 普通用户登录操作
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/oyuserLogin")
    public Oyuser oyuserLogin(Oyuser oyuser){
        return oyuserService.findByOynumAndOypswd(oyuser.getOynum(),oyuser.getOypswd());
    }

    /**
     * 普通用户注册
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/addOyuser")
    public Oyuser addOyuser(Oyuser oyuser){
        if (oyuserService.findByOynum(oyuser.getOynum()) == null){
            logger.info("注册账号："+oyuser.getOynum()+"成功！");
            return oyuserService.addOrUpdata(oyuser);
        }else{
            logger.info("用户账号："+oyuser.getOynum()+"存在！");
            return oyuserService.findByOynum("");
        }
    }

    /**
     * 普通用户更新个人头像信息
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/updataOyuserIcon")
    public Oyuser updataOyuserIcon(Oyuser oyuser){
        Oyuser o=oyuserService.findByOyid(oyuser.getOyid());
        o.setOyicon(oyuser.getOyicon());
        return oyuserService.addOrUpdata(o);
    }

    /**
     * 普通用户更新个人信息(昵称、简介、邮箱)
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/updataOyuserInfo")
    public Oyuser updataOyuserInfo(Oyuser oyuser){
        Oyuser o=oyuserService.findByOyid(oyuser.getOyid());
        o.setOyname(oyuser.getOyname());
        o.setOyemail(oyuser.getOyemail());
        o.setOybrief(oyuser.getOybrief());
        return oyuserService.addOrUpdata(o);
    }

    /**
     * 根据id、密码查询
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/findByOyidAndAndOypswd")
    public Oyuser findByOyidAndAndOypswd(Oyuser oyuser){
        return oyuserService.findByOyidAndAndOypswd(oyuser.getOyid(),oyuser.getOypswd());
    }

    /**
     * 普通用户更新个人密码信息
     * @param oyuser
     * @return
     */
    @PostMapping(value = "/updataOyuserPswd")
    public Oyuser updataOyuserPswd(Oyuser oyuser){
        Oyuser o=oyuserService.findByOyid(oyuser.getOyid());
        o.setOypswd(oyuser.getOypswd());
        return oyuserService.addOrUpdata(o);
    }

}

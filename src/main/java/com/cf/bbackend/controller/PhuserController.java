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

}

package com.cf.bbackend.controller;

import com.cf.bbackend.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final static Logger logger= LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    /**
     * 查询所有管理员
     * @return
     */
    @GetMapping(value = "/email")
    public void sendSimpleMail() throws Exception {
        logger.info("发送测试邮件！");
        emailService.sendSimpleEmail("775753078@qq.com","测试邮件主题","测试邮件内容");
    }
}

package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Consumer;
import com.cf.bbackend.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作
 */
@RestController
@RequestMapping("/user")
public class ConsumerController {

    private final static Logger logger= LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ConsumerService consumerService;

    /**
     * 用户 注册
     * @param consumer
     * @return
     */
    @PostMapping(value = "/addUser")
    public Consumer addUser(Consumer consumer){
        consumer.setUrnum(consumer.getUrnum());
        consumer.setUrpswd(consumer.getUrpswd());
        if(consumerService.findByUrnum(consumer.getUrnum())==null){
            logger.info("注册用户账号："+consumer.getUrnum()+"  成功！");
            return consumerService.addOrUpdata(consumer);
        }else{
            logger.info("用户账号："+consumer.getUrnum()+"  已存在，注册失败！");
            return consumerService.findByUrnum("");
        }
    }

    /**
     * 用户 更新
     * @param consumer
     * @return
     */
    @PostMapping(value = "/updataUser")
    public Consumer updataUser(Consumer consumer){
        consumer.setUrid(consumer.getUrid());
        consumer.setUrname(consumer.getUrname());
        consumer.setUricon(consumer.getUricon());
        consumer.setUrnum(consumer.getUrnum());
        consumer.setUrpswd(consumer.getUrpswd());
        consumer.setUremail(consumer.getUremail());
        consumer.setUrexplain(consumer.getUrexplain());
        return consumerService.addOrUpdata(consumer);
    }
}

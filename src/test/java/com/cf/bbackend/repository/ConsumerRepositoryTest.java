package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Consumer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerRepositoryTest {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Test
    public void findByIdTest(){
        consumerRepository.findById(1);
        System.out.println(consumerRepository.findById(1).toString());
    }

    @Test
    public void saveTest(){
        Consumer consumer=new Consumer();
        consumer.setUrname("小红");
        consumer.setUrnum("账号4");
        consumer.setUrpswd("喵喵");
        consumer.setUremail("email@123.com");
        consumer.setUrexplain("简介");
        consumer.setUricon("头像路径");
        consumerRepository.save(consumer);
        Assert.assertNotNull(consumerRepository.save(consumer));
    }

    @Test
    public void findByUrnameInTest(){
        List<String> list= Arrays.asList("笑话","小明","小红");
        List<Consumer> result=consumerRepository.findByUrnameIn(list);
        System.out.println(result.toString());
//        Assert.assertNotEquals(0,result.size());
    }


}
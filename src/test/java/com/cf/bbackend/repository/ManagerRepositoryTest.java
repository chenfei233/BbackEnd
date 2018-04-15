package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Manager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void findByIdTest(){
        managerRepository.findById(2);
        System.out.println(managerRepository.findById(2).toString());
    }

    @Test
    public void saveTest(){
        Manager manager=new Manager();
        manager.setAdmname("测试3");
        manager.setAdmnum("账号3");
        manager.setAdmpwd("喵喵3");
        manager.setAdmicon("头像3");
        managerRepository.save(manager);
        Assert.assertNotNull(managerRepository.save(manager));
    }

    @Test
    public void findByAdmidInTest(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<Manager> result=managerRepository.findByAdmidIn(list);
        System.out.println(result.toString());
        Assert.assertNotEquals(0,result.size());
    }


}
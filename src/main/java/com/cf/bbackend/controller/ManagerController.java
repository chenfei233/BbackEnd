package com.cf.bbackend.controller;

import com.cf.bbackend.repository.ManagerRepository;
import com.cf.bbackend.domain.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理操作
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final static Logger logger= LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerRepository managerRepository;

    /**
     * 查询所有管理员
     * @return
     */
    @GetMapping(value = "/admin")
    public List<Manager> managerList(){
        return managerRepository.findAll();
    }


    /**
     * 管理员登录
     * @param manager
     * @return
     */
    @GetMapping(value = "/adminLogin")
    public Manager adminLogin(Manager manager){
        String admnum=manager.getAdmnum();
        String admpwd=manager.getAdmpwd();
        return managerRepository.findByAdmnumAndAdmpwd(admnum, admpwd);
//        Assert.assertNotNull(managerRepository.findByAdmnumAndAdmpwd(admnum, admpwd));
    }

    /**
     * 管理员注册
     * @param manager
     * @return
     */
    @PostMapping(value = "/adminRegister")
    public Manager addManager(Manager manager){
        manager.setAdmnum(manager.getAdmnum());
        manager.setAdmpwd(manager.getAdmpwd());
        if(managerRepository.findByAdmnum(manager.getAdmnum()) == null){
            logger.info("注册用户账号："+manager.getAdmnum()+"  成功！");
            return managerRepository.save(manager);
        }else{
            logger.info("用户账号："+manager.getAdmnum()+"  已存在，注册失败！");
            return managerRepository.findByAdmnum("0");
        }
    }
















    /**
     * 根据账号查找管理员
     * @param manager
     * @return
     */
    @PostMapping(value = "/findByAdmnum")
    public Manager findByAdmnum(Manager manager){
        Manager mone=managerRepository.findByAdmnum(manager.getAdmnum());
        if(mone == null){
            logger.info("为空null");
        }else{
            logger.info(" 啊啊啊 ");
        }
        return managerRepository.findByAdmnum(manager.getAdmnum());
    }
}

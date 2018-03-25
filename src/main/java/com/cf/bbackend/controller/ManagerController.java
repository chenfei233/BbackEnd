package com.cf.bbackend.controller;

import com.cf.bbackend.repository.ManagerRepository;
import com.cf.bbackend.domain.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
     * 添加一个管理员
     * @param manager
     * @return
     */
    @PostMapping(value = "/admin")
    public Manager managerAdd(Manager manager){
//        manager.setM_name(manager.getM_name());
        manager.setM_num(manager.getM_num());
        manager.setM_pwd(manager.getM_pwd());
        return managerRepository.save(manager);
    }
}

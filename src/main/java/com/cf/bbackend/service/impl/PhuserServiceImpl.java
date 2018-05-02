package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Phuser;
import com.cf.bbackend.repository.PhuserRepository;
import com.cf.bbackend.service.PhuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发布用户表
 */
@Service
public class PhuserServiceImpl implements PhuserService{

    @Autowired
    private PhuserRepository phuserRepository;

    @Override
    public Phuser findByPhid(Integer Phid) {
        return phuserRepository.findByPhid(Phid);
    }

    @Override
    public Phuser findByPhnum(String Phnum) {
        return phuserRepository.findByPhnum(Phnum);
    }

    @Override
    public Phuser findByPhnumAndPhpswd(String Phnum, String Phpswd) {
        return phuserRepository.findByPhnumAndPhpswd(Phnum,Phpswd);
    }

    @Override
    public Phuser addOrUpdata(Phuser phuser) {
        return phuserRepository.save(phuser);
    }
}

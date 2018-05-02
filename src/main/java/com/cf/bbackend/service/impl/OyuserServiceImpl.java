package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Oyuser;
import com.cf.bbackend.repository.OyuserRepository;
import com.cf.bbackend.service.OyuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 普通用户表
 */
@Service
public class OyuserServiceImpl implements OyuserService{

    @Autowired
    private OyuserRepository oyuserRepository;

    @Override
    public Oyuser findByOyid(Integer Oyid) {
        return oyuserRepository.findByOyid(Oyid);
    }

    @Override
    public Oyuser findByOynum(String Oynum) {
        return oyuserRepository.findByOynum(Oynum);
    }

    @Override
    public Oyuser findByOynumAndOypswd(String Oynum, String Oypswd) {
        return oyuserRepository.findByOynumAndOypswd(Oynum,Oypswd);
    }

    @Override
    public Oyuser addOrUpdata(Oyuser oyuser) {
        return oyuserRepository.save(oyuser);
    }
}

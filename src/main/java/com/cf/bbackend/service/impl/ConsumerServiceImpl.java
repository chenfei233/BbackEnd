package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Consumer;
import com.cf.bbackend.repository.ConsumerRepository;
import com.cf.bbackend.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public Consumer findByUrid(Integer urid) {
        return consumerRepository.findByUrid(urid);
    }

    @Override
    public Consumer findByUrnum(String urnum) {
        return consumerRepository.findByUrnum(urnum);
    }

    @Override
    public Consumer findByUrnumAndUrpswd(String urnum, String urpswd) {
        return consumerRepository.findByUrnumAndUrpswd(urnum,urpswd);
    }

    @Override
    public List<Consumer> findAll() {
        return consumerRepository.findAll();
    }

    @Override
    public List<Consumer> findByUrnameIn(List<String> urnameList) {
        return consumerRepository.findByUrnameIn(urnameList);
    }

    @Override
    public Consumer addOrUpdata(Consumer consumers) {
        return consumerRepository.save(consumers);
    }
}

package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Collect;
import com.cf.bbackend.repository.CollectRepository;
import com.cf.bbackend.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectRepository collectRepository;

    @Override
    public int countByAieid(Integer Aieid) {
        return collectRepository.countByAieid(Aieid);
    }

    @Override
    public List<Collect> findByOyid(Integer Oyid) {
        return collectRepository.findByOyid(Oyid);
    }

    @Override
    public int countByOyid(Integer Oyid) {
        return collectRepository.countByAieid(Oyid);
    }

    @Override
    public void deleteByAieid(Integer Aieid) {
        collectRepository.countByAieid(Aieid);
    }

    @Override
    public void deleteByOyidAndAieid(Integer Oyid, Integer Aieid) {
        collectRepository.deleteByOyidAndAieid(Oyid,Aieid);
    }
}

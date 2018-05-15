package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Collect;
import com.cf.bbackend.repository.CollectRepository;
import com.cf.bbackend.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Collect findByOyid(Integer Oyid) {
        return collectRepository.findByOyid(Oyid);
    }

    @Override
    public void deleteByCltid(Integer Cltid) {
        collectRepository.deleteById(Cltid);
    }
}

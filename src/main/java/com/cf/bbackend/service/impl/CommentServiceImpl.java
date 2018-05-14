package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Commentary;
import com.cf.bbackend.repository.CommentaryRepository;
import com.cf.bbackend.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论表
 */
@Service
public class CommentServiceImpl  implements CommentaryService {

    @Autowired
    private CommentaryRepository commentRepository;

    @Override
    public int countByAieid(Integer Aieid) {
        return commentRepository.countByAieid(Aieid);
    }

    @Override
    public List<Commentary> findByAieid(Integer Aieid) {
        return commentRepository.findByAieid(Aieid);
    }

    @Override
    public Commentary addOrUpdata(Commentary commentary) {
        return commentRepository.save(commentary);
    }
}

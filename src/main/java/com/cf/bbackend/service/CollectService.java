package com.cf.bbackend.service;

import com.cf.bbackend.domain.Collect;

/**
 * 收藏
 */
public interface CollectService {

    /** 查询该文章下的收藏数目 */
    int countByAieid(Integer Aieid);

    /** 根据用户id查询收藏 */
    Collect findByOyid(Integer Oyid);

    /** 根据用户id查询收藏 */
    void deleteByCltid(Integer Cltid);

}

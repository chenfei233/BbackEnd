package com.cf.bbackend.service;

import com.cf.bbackend.domain.Collect;

import java.util.List;

/**
 * 收藏
 */
public interface CollectService {

    /** 根据id删除收藏 */
    void deleteByCltid(Integer Cltid);

    /** 查询该文章下的收藏数目 */
    int countByAieid(Integer Aieid);

    /** 根据用户id查询收藏 */
    List<Collect> findByOyid(Integer Oyid);

    /** 该用户下的收藏数目 */
    int countByOyid(Integer Oyid);

    /** 根据文章id删除收藏 */
    void deleteByAieid(Integer Aieid);

    /** 根据用户id、文章id删除收藏 */
    void deleteByOyidAndAieid(Integer Oyid,Integer Aieid);

    /** 添加更新收藏信息 */
    Collect addOrUpdata(Collect collect);

    /** 查询该用户是否收藏此文章 */
    List<Collect> findByOyidAndAieid(Integer Oyid,Integer Aieid);
}

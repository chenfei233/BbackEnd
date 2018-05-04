package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Collect;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 收藏
 */
public interface CollectRepository extends JpaRepository<Collect,Integer> {

    /** 根据用户id查询收藏 */
    Collect findByOyid(Integer Oyid);

}
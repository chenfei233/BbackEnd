package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户
 */
public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{

    /** 根据ID查询 */
    Consumer findByUrid(Integer urid);

    /** 根据账号查询 */
    Consumer findByUrnum(String urnum);

    /** 根据 账号、密码 查询 */
    Consumer findByUrnumAndUrpswd(String urnum,String urpswd);

    /** 根据用户名查询 多个 */
    List<Consumer> findByUrnameIn(List<String> urnameList);
}

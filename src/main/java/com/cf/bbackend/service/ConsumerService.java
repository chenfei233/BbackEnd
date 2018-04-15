package com.cf.bbackend.service;

import com.cf.bbackend.domain.Consumer;

import java.util.List;

/**
 * 用户
 */
public interface ConsumerService {

    /** 查询某一条. */
    Consumer findByUrid(Integer urid);

    /** 根据账号查询 */
    Consumer findByUrnum(String urnum);

    /** 根据 账号、密码 查询 */
    Consumer findByUrnumAndUrpswd(String urnum,String urpswd);

    /** 查询所有. */
    List<Consumer> findAll();

    /** 查询list(存的urname)中的. */
    List<Consumer> findByUrnameIn(List<String> urnameList);

    /** 添加/更新. */
    Consumer addOrUpdata(Consumer consumers);
}

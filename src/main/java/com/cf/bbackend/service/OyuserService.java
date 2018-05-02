package com.cf.bbackend.service;

import com.cf.bbackend.domain.Oyuser;

/**
 * 普通用户表
 */
public interface OyuserService {

    /** 根据id查询某个用户 */
    Oyuser findByOyid(Integer Oyid);

    /** 查询是否存在该账号 */
    Oyuser findByOynum(String Oynum);

    /** 匹配账号、密码 */
    Oyuser findByOynumAndOypswd(String Oynum,String Oypswd);

    /** 添加更新用户信息 */
    Oyuser addOrUpdata(Oyuser oyuser);
    
}

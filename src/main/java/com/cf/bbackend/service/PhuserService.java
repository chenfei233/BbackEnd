package com.cf.bbackend.service;

import com.cf.bbackend.domain.Phuser;

/**
 * 发布用户表
 */
public interface PhuserService {

    /** 根据id查询用户 */
    Phuser findByPhid(Integer Phid);

    /** 查询当前账号是否存在 */
    Phuser findByPhnum(String Phnum);

    /** 匹配账号、密码  */
    Phuser findByPhnumAndPhpswd(String Phnum,String Phpswd);

    /** 添加更新用户信息 */
    Phuser addOrUpdata(Phuser phuser);
}

package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Phuser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 发布用户表
 */
public interface PhuserRepository extends JpaRepository<Phuser,Integer>{

    /** 根据id查询用户 */
    Phuser findByPhid(Integer Phid);

    /** 查询当前账号是否存在 */
    Phuser findByPhnum(String Phnum);

    /** 匹配账号、密码  */
    Phuser findByPhnumAndPhpswd(String Phnum,String Phpswd);

    /** 根据id、密码查询 */
    Phuser findByPhidAndAndPhpswd(Integer Phid,String Phpswd);

}

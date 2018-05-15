package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Oyuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OyuserRepository extends JpaRepository<Oyuser, Integer> {

    /** 根据id查询 */
    Oyuser findByOyid(Integer Oyid);

    /** 查询是否存在该账号 */
    Oyuser findByOynum(String Oynum);

    /** 匹配账号、密码 */
    Oyuser findByOynumAndOypswd(String Oynum,String Oypswd);

    /** 根据id、密码查询 */
    Oyuser findByOyidAndAndOypswd(Integer Oyid,String Oypswd);

}

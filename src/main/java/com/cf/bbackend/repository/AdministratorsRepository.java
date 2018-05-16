package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorsRepository extends JpaRepository<Administrators,Integer> {

    /** 根据账号来查询 */
    Administrators findByAdmnum(String Admnum);

    /** 根据账号、密码来查询 */
    Administrators findByAdmnumAndAdmpwd(String Admnum,String Admpwd);

    /** 根据id来查询 */
    Administrators findByAdmid(Integer Admid);

    /** 根据id、密码来查询 */
    Administrators findByAdmidAndAdmpwd(Integer Admid,String Admpwd);

}

package com.cf.bbackend.service;

import com.cf.bbackend.domain.Administrators;
import org.springframework.stereotype.Service;

/**
 * 管理员
 */
public interface AdministratorsService {

    /** 根据账号来查询 */
    Administrators findByAdmnum(String Admnum);

    /** 根据账号、密码来查询 */
    Administrators findByAdmnumAndAdmpwd(String Admnum,String Admpwd);

    /** 更新/添加 */
    Administrators addOrUpdata(Administrators administrators);

    /** 根据id来查询 */
    Administrators findByAdmid(Integer Admid);

    /** 根据id、密码来查询 */
    Administrators findByAdmidAndAdmpwd(Integer Admid,String Admpwd);

}

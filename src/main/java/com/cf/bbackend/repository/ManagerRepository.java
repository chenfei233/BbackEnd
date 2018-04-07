package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    Manager findByAdmnum(String Admnum); // 根据账号来查询

    Manager findByAdmnumAndAdmpwd(String admnum,String admpwd); // 根据账号 密码来查询

}

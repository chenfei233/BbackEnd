package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 管理
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    /** 根据账号来查询 */
    Manager findByAdmnum(String Admnum);

    /** 根据账号 密码来查询 */
    Manager findByAdmnumAndAdmpwd(String admnum,String admpwd);

    /** 根据id查询 多个 */
    List<Manager> findByAdmidIn(List<Integer> admidList);
}

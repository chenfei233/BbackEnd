package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Administrators;
import com.cf.bbackend.repository.AdministratorsRepository;
import com.cf.bbackend.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员
 */
@Service
public class AdministratorsServiceImpl implements AdministratorsService {

    @Autowired
    private AdministratorsRepository administratorsRepository;

    @Override
    public Administrators findByAdmnum(String Admnum) {
        return administratorsRepository.findByAdmnum(Admnum);
    }

    @Override
    public Administrators findByAdmnumAndAdmpwd(String Admnum, String Admpwd) {
        return administratorsRepository.findByAdmnumAndAdmpwd(Admnum,Admpwd);
    }

    @Override
    public Administrators addOrUpdata(Administrators administrators) {
        return administratorsRepository.save(administrators);
    }

    @Override
    public Administrators findByAdmid(Integer Admid) {
        return administratorsRepository.findByAdmid(Admid);
    }

    @Override
    public Administrators findByAdmidAndAdmpwd(Integer Admid, String Admpwd) {
        return administratorsRepository.findByAdmidAndAdmpwd(Admid,Admpwd);
    }
}

package com.cf.bbackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    @GeneratedValue
    private Integer m_id;
    private String m_name;
    private String m_num;
    private String m_pwd;

    public Manager() {
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_num() {
        return m_num;
    }

    public void setM_num(String m_num) {
        this.m_num = m_num;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }
}

package com.cf.bbackend.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 类别表
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer cgyid;   // 类别id
    private String cgyname;  // 类别名
    private String cgyicon;  // 类别图标

    public Integer getCgyid() {
        return cgyid;
    }

    public void setCgyid(Integer cgyid) {
        this.cgyid = cgyid;
    }

    public String getCgyname() {
        return cgyname;
    }

    public void setCgyname(String cgyname) {
        this.cgyname = cgyname;
    }

    public String getCgyicon() {
        return cgyicon;
    }

    public void setCgyicon(String cgyicon) {
        this.cgyicon = cgyicon;
    }
}

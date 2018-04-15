package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * 类别表
 */
@Entity
@Data
public class Category {

    /** 类别id. */
    @Id
    @GeneratedValue
    private Integer cgyid;

    /** 类别名. */
    private String cgyname;

    /** 类别图标. */
    private String cgyicon;

    public Category() {
    }

    public Category(String cgyname, String cgyicon) {
        this.cgyname = cgyname;
        this.cgyicon = cgyicon;
    }
}

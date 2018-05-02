package com.cf.bbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 收藏表collect
 */
@Entity
@Data
public class Collect {

    /** 收藏id. */
    @Id
    @GeneratedValue
    private Integer cltid;

    /** 文章id. */
    private Integer aieid;

    /** 普通用户id. */
    private Integer oyid;

    public Collect() {
    }

    public Collect(Integer aieid, Integer oyid) {
        this.aieid = aieid;
        this.oyid = oyid;
    }
}

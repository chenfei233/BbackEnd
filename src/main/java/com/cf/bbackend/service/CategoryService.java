package com.cf.bbackend.service;

import com.cf.bbackend.domain.Category;

import java.util.List;

/**
 * 类别
 */
public interface CategoryService {

    /** 查询一条. */
    Category findByCgyid(Integer cgyid);

    /** 查询所有. */
    List<Category> categoryList();

    /** 添加/更新. */
    Category addOrUpdata(Category category);
}

package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类别
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>  {

    /** 根据ID查询. */
    Category findByCgyid(Integer cgyid);
}

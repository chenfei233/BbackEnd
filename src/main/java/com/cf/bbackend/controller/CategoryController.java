package com.cf.bbackend.controller;

import com.cf.bbackend.domain.Category;
import com.cf.bbackend.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类别操作
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final static Logger logger= LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /** 添加/更新. */
    @PostMapping(value = "/save")
    public Category addOrUpdata(Category category){
        logger.info(" 类别-->添加/更新 ");
        category.setCgyname(category.getCgyname());
        category.setCgyicon(category.getCgyicon());
        return categoryService.addOrUpdata(category);
    }

    /** 查询一条. */
    @GetMapping(value = "/byOne")
    public Category findByCgyid(Category category){
        logger.info(" 类别-->查询 ");
        return categoryService.findByCgyid(category.getCgyid());
    }
}

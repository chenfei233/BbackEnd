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

import java.util.List;

/**
 * 类别操作
 */
@RestController
@RequestMapping("/Category")
public class CategoryController {

    private final static Logger logger= LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /** 添加/更新. */
    @PostMapping(value = "/addOrUpdata")
    public Category addOrUpdata(Category category){
        logger.info(" 类别-->添加/更新 ");
        category.setCgyname(category.getCgyname());
        category.setCgyicon(category.getCgyicon());
        return categoryService.addOrUpdata(category);
    }

    /** 查询一条. */
    @GetMapping(value = "/findByCgyid")
    public Category findByCgyid(Category category){
        logger.info(" 类别-->查询 ");
        return categoryService.findByCgyid(category.getCgyid());
    }

    /** 查询显示全部 */
    @GetMapping(value = "/findAll")
    public List<Category> findAll(){
        logger.info(" 类别-->查询-->显示全部 ");
        return categoryService.findAll();
    }
}

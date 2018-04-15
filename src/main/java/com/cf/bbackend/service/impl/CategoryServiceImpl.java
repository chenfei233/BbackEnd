package com.cf.bbackend.service.impl;

import com.cf.bbackend.domain.Category;
import com.cf.bbackend.repository.CategoryRepository;
import com.cf.bbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类别
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByCgyid(Integer cgyid) {
        return categoryRepository.findByCgyid(cgyid);
    }

    @Override
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addOrUpdata(Category category) {
        return categoryRepository.save(category);
    }
}

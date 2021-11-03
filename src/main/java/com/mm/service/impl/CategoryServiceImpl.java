package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.domain.Category;
import com.mm.mapper.CategoryMapper;
import com.mm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public BaseDao<Category> getBaseDao() {
        return categoryMapper;
    }
}

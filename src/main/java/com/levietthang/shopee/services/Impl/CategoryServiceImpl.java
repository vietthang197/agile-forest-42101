package com.levietthang.shopee.services.Impl;

import com.levietthang.shopee.entities.Category;
import com.levietthang.shopee.repositories.repository.CategoryRepository;
import com.levietthang.shopee.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}

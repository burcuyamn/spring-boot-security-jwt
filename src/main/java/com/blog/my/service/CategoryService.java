package com.blog.my.service;

import com.blog.my.model.Category;
import com.blog.my.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public Category findById(String oid){
        return categoryRepository.findById(oid).get();
    }

    public void deleteByOid(String oid){
        categoryRepository.deleteByOid(oid);
    }
}

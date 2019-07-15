package com.blog.my.service;

import com.blog.my.model.Category;
import com.blog.my.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Transactional
    public void deleteByOid(String oid){
        categoryRepository.deleteByOid(oid);
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }
}

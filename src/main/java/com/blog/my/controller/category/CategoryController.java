package com.blog.my.controller.category;

import com.blog.my.model.Category;
import com.blog.my.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    private ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<?> save(@Valid @RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PutMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    private void delete(@RequestParam("oid") String oid){
        categoryService.deleteByOid(oid);
    }
}

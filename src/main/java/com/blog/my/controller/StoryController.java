package com.blog.my.controller;

import com.blog.my.model.Story;
import com.blog.my.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/all")
    private ResponseEntity<?> getAll(){
        List<Story> stories = storyService.findAll();
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<?> saveStory(@Valid @RequestBody Story story){
        storyService.save(story);
        return ResponseEntity.ok(new ArrayList<>());
    }
}

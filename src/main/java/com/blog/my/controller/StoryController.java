package com.blog.my.controller;

import com.blog.my.model.Story;
import com.blog.my.model.User;
import com.blog.my.service.StoryService;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("story")
public class StoryController {

    @Autowired
    private UserService userService;

    @Autowired
    private StoryService storyService;

    @GetMapping("/all")
    private ResponseEntity<List<Story>> getAll(){
        List<Story> stories = storyService.findAll();
        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    private void save(@RequestParam("userOid") String userOid,
                      @RequestParam("title") String title,
                      @RequestParam("body") String body,
                      @RequestParam("categoryType") String categoryType){

        User user = userService.findById(userOid);
        Story story = new Story(user, title, body, null);
        storyService.save(story);
    }
}
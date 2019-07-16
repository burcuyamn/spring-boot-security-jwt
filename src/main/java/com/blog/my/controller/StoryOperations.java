package com.blog.my.controller;

import com.blog.my.controller.authentication.AuthenticationHandler;
import com.blog.my.model.Story;
import com.blog.my.model.User;
import com.blog.my.service.StoryService;
import org.fest.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidParameterException;
import java.util.Date;

public class StoryOperations {

    @Autowired
    private StoryService storyService;

    @Autowired
    private AuthenticationHandler authenticationHandler;

    public void createNewStory(Story story){
        if(story.getCategory() == null){
            throw  new InvalidParameterException("category can not be empty");
        }
        if(Strings.isNullOrEmpty(story.getTitle())){
            throw  new InvalidParameterException("title can not be empty");
        }
        if(Strings.isNullOrEmpty(story.getBody())){
            throw  new InvalidParameterException("body can not be empty");
        }

        User user = authenticationHandler.getCurrentUser();
        story.setUser(user);
        story.setCreatedDate(new Date());
        storyService.save(story);
    }
}

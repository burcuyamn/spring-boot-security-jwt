package com.blog.my.controller.story;

import com.blog.my.controller.authentication.AuthenticationHandler;
import com.blog.my.model.Story;
import com.blog.my.model.User;
import com.blog.my.service.StoryService;
import org.fest.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class StoryOperations {

    @Autowired
    private StoryService storyService;

    @Autowired
    private AuthenticationHandler authenticationHandler;

    public void createNewStory(Story story){
        checkNotNull(story.getCategory());
        checkNotNull(story.getTitle());
        checkNotNull(story.getBody());

        User user = authenticationHandler.getCurrentUser();
        story.setUser(user);
        story.setCreatedDate(new Date());
        storyService.save(story);
    }
}

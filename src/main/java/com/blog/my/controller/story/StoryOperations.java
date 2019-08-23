package com.blog.my.controller.story;

import com.blog.my.controller.authentication.AuthenticationHandler;
import com.blog.my.dto.request.StoryDTO;
import com.blog.my.model.Category;
import com.blog.my.model.Story;
import com.blog.my.model.User;
import com.blog.my.service.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

    public void save(StoryDTO storyDTO){
        checkNotNull(storyDTO.getCategoryOid());
        checkNotNull(storyDTO.getTitle());
        checkNotNull(storyDTO.getBody());

        Category category = categoryService.findById(storyDTO.getCategoryOid());
        User user = authenticationHandler.getCurrentUser();

        Story story = new Story(user, category, storyDTO.getTitle(), storyDTO.getBody(), new Date());
        storyService.save(story);
    }

    public void update(StoryDTO storyDTO){
        checkNotNull(storyDTO.getOid());
        checkNotNull(storyDTO.getCategoryOid());
        checkNotNull(storyDTO.getTitle());
        checkNotNull(storyDTO.getBody());

        Category category = categoryService.findById(storyDTO.getCategoryOid());

        Story story = storyService.findById(storyDTO.getOid());
        story.setCategory(category);
        story.setTitle(storyDTO.getTitle());
        story.setBody(storyDTO.getBody());

        storyService.update(story);
    }
}

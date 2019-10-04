package com.blog.my.controller.story;

import com.blog.my.controller.authentication.AuthenticationHandler;
import com.blog.my.dto.request.StoryDTO;
import com.blog.my.json.JSONManager;
import com.blog.my.model.Category;
import com.blog.my.model.Story;
import com.blog.my.model.User;
import com.blog.my.service.CategoryService;
import com.blog.my.service.StoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fest.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class StoryOperations {

    @Autowired
    private StoryService storyService;

    @Autowired
    private AuthenticationHandler authenticationHandler;

    @Autowired
    private CategoryService categoryService;

    public void save(StoryDTO storyDTO) throws JsonProcessingException {
        checkNotNull(storyDTO.getCategoryOid());
        checkNotNull(storyDTO.getTitle());
        checkNotNull(storyDTO.getBody());

        User user = authenticationHandler.getCurrentUser();
        Category category = categoryService.findById(storyDTO.getCategoryOid());
        String body = JSONManager.getMapper().writeValueAsString(storyDTO.getBody());

        Story story = new Story(user, category, storyDTO.getTitle(), body, new Date());
        storyService.save(story);
    }

    public void update(StoryDTO storyDTO) throws JsonProcessingException {
        checkNotNull(storyDTO.getOid());
        checkNotNull(storyDTO.getCategoryOid());
        checkNotNull(storyDTO.getTitle());
        checkNotNull(storyDTO.getBody());

        Category category = categoryService.findById(storyDTO.getCategoryOid());
        String body = JSONManager.getMapper().writeValueAsString(storyDTO.getBody());

        Story story = storyService.findById(storyDTO.getOid());
        story.setCategory(category);
        story.setTitle(storyDTO.getTitle());
        story.setBody(body);

        storyService.update(story);
    }
}

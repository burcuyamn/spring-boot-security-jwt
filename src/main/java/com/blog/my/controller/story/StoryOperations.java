package com.blog.my.controller.story;

import com.blog.my.controller.authentication.AuthenticationHandler;
import com.blog.my.dto.request.StoryDTO;
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

    public void createNewStory(StoryDTO storyDTO){
        checkNotNull(storyDTO.getCategoryOid());
        checkNotNull(storyDTO.getTitle());
        checkNotNull(storyDTO.getBody());

        User user = authenticationHandler.getCurrentUser();

        Story story = convertStoryDTOToStory(storyDTO);
        storyDTO.setUserOid(user.getOid());
        //story.setUser(user);
        story.setCreatedDate(new Date());

        storyService.save(story);
    }

    public void updateStory(StoryDTO story){
        checkNotNull(story.getOid());
        checkNotNull(story.getCategoryOid());
        checkNotNull(story.getTitle());
        checkNotNull(story.getBody());

        storyService.update(story);
    }

    public Story convertStoryDTOToStory(StoryDTO storyDTO){
        Story story = new Story();
        return story;
    }
}

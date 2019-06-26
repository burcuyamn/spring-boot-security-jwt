package com.blog.my.service;

import com.blog.my.model.Story;
import com.blog.my.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public Story save(Story story){
        return storyRepository.save(story);
    }
}

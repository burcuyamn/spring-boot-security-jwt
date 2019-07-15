package com.blog.my.service;

import com.blog.my.model.Story;
import com.blog.my.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public List<Story> findAll(){
      return storyRepository.findAll();
    }

    public Story findById(String oid){
        return storyRepository.findById(oid).get();
    }

    public void save(Story story){
        storyRepository.save(story);
    }
}

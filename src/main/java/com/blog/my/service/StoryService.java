package com.blog.my.service;

import com.blog.my.dto.request.StoryDTO;
import com.blog.my.model.Story;
import com.blog.my.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void deleteByOid(String oid){
        storyRepository.deleteByOid(oid);
    }

    @Transactional
    public void update(StoryDTO story){
        storyRepository.update(story.getOid(), story.getCategoryOid(), story.getTitle(), story.getBody());
    }
}

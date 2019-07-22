package com.blog.my.controller.story;

import com.blog.my.model.Story;
import com.blog.my.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@RequestMapping("story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private StoryOperations storyOperations;

    @GetMapping("/all")
    private ResponseEntity<?> getAll(){
        List<Story> stories = storyService.findAll();
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<?> saveStory(@Valid @RequestBody Story story){
        storyOperations.createNewStory(story);
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PutMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    private void deleteStory(@RequestParam("oid") String oid){
        checkNotNull(oid);
        storyService.deleteByOid(oid);

    }

    @PutMapping("/update")
    protected ResponseEntity<Story> updateStory(@Valid @RequestBody Story story){

        return null;
    }
}

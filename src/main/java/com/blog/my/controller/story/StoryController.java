package com.blog.my.controller.story;

import com.blog.my.dto.request.StoryDTO;
import com.blog.my.model.Story;
import com.blog.my.service.StoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    private ResponseEntity<?> save(@Valid @RequestBody StoryDTO storyDTO) throws JsonProcessingException {
        storyOperations.save(storyDTO);
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PutMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    private void delete(@RequestParam("oid") String oid){
        checkNotNull(oid);
        storyService.deleteByOid(oid);
    }

    @PostMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    private void update(@Valid @RequestBody StoryDTO storyDTO) throws JsonProcessingException {
        storyOperations.update(storyDTO);
    }
}
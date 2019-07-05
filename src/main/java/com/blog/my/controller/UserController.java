package com.blog.my.controller;

import com.blog.my.model.User;
import com.blog.my.repository.UserRepository;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> all(){
        List<User> users = userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("add/role")
    public User addRole(@RequestParam("userOid") String useroid,
                        @RequestParam("roleOid") String roleOid){
        return userService.addRole(useroid,roleOid);
    }
}

package com.blog.my.controller.user;

import com.blog.my.dto.request.UserDTO;
import com.blog.my.model.User;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOperations userOperations;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody UserDTO userDTO) {
    userOperations.save(userDTO);
    }
}

package com.blog.my.controller.user;

import com.blog.my.dto.UserDTO;
import com.blog.my.model.User;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOperations userOperations;

    @PostMapping(value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        User user = userService.save(userOperations.convertUserDTOToUser(userDTO));
        UserDTO newUsersDTO = userOperations.convertUserToUserDTO(user);
        return ResponseEntity.ok(newUsersDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}

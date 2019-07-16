package com.blog.my.controller.authentication;

import com.blog.my.model.authentication.CurrentUser;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationHandler {

    @Autowired
    private UserService userService;

    public CurrentUser getCurrentClientUser(){
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.blog.my.model.User user = userService.findByUsername(authUser.getUsername());
        return new CurrentUser(user);
    }

    public com.blog.my.model.User getCurrentUser (){
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.blog.my.model.User user = userService.findByUsername(authUser.getUsername());
        return user;
    }
}

package com.blog.my.controller.user;

import com.blog.my.dto.request.UserDTO;
import com.blog.my.model.User;
import com.blog.my.service.JwtUserDetailsService;
import com.blog.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class UserOperations {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public void save(UserDTO userDTO){
        checkNotNull(userDTO.getUsername());
        checkNotNull(userDTO.getPassword());
        checkNotNull(userDTO.getEmail());

        User user = convertUserDTOToUser(userDTO);
        userService.save(user);
    }

    public User convertUserDTOToUser(UserDTO userDTO){
        userDTO.setPassword(userDetailsService.encodePassword(userDTO.getPassword()));

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}

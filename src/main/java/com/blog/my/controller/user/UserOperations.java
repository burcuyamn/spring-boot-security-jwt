package com.blog.my.controller.user;

import com.blog.my.dto.UserDTO;
import com.blog.my.model.User;
import com.blog.my.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class UserOperations {

    @Autowired
    private JwtUserDetailsService userDetailsService;


    public User convertUserDTOToUser(UserDTO userDTO){
        checkNotNull(userDTO.getUsername());
        checkNotNull(userDTO.getPassword());
        checkNotNull(userDTO.getEmail());
        userDTO.setPassword(userDetailsService.encodePassword(userDTO.getPassword()));
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO convertUserToUserDTO(User user){
        return new UserDTO(user.getOid(), user.getUsername(), user.getEmail());
    }
}

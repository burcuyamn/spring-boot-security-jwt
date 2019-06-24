package com.blog.my.service;

import com.blog.my.model.User;
import com.blog.my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }
}

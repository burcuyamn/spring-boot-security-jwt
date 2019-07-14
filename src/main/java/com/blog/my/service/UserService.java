package com.blog.my.service;

import com.blog.my.model.User;
import com.blog.my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(String oid){
        return userRepository.findById(oid).get();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username).get();
    }

    public User findByUsernameAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).get();
    }

    public void deleteByOid(String oid){
        userRepository.deleteByOid(oid);
    }
}

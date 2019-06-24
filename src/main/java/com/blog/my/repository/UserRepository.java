package com.blog.my.repository;

import com.blog.my.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @Transactional(timeout = 8)
    List<User> findAll();

    List<User> findByUsername(String username);
}

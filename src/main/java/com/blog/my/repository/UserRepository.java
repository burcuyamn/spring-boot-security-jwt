package com.blog.my.repository;

import com.blog.my.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    @Transactional(timeout = 8)
    Iterable<User> findAll();

    List<User> findByUsername(String username);
}

package com.blog.my.service;

import com.blog.my.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IUserService {
    List<User> findAllUser();
}

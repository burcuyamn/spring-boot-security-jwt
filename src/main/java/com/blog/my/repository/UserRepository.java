package com.blog.my.repository;

import com.blog.my.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("select u from User u where u.deleted is null")
    List<User> findAll();

    @Modifying
    @Query("update User set lastUpdated = current_timestamp, deleted = current_timestamp where oid =:oid ")
    void deleteByOid(@Param("oid") String oid);
}
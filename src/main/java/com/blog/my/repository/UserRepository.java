package com.blog.my.repository;

import com.blog.my.model.User;
import com.blog.my.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query(value = "update User u set u.role = ? where u.userOid = ?",
            nativeQuery = true)
    int updateUserSetRolesForName(Set<Role> role, String userOid);


}
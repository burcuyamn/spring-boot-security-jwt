package com.blog.my.repository;

import com.blog.my.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByName(String name);

    @Modifying
    @Query("select c from Category c where c.deleted is null")
    List<Category> findAll();

    @Modifying
    @Query("update Category set deleted = current_date where oid =:oid ")
    void deleteByOid(@Param("oid") String oid);
}

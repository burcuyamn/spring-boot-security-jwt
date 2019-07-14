package com.blog.my.repository;

import com.blog.my.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Modifying
    @Query("update Category set deleted = current_date where oid =:oid ")
    void deleteByOid(@Param("oid") String oid);
}

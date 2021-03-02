package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity,Integer> {

    @Query("SELECT c FROM CategoryEntity c WHERE c.c_group_id.id = ?1 and c.id <> ?2")
    List<CategoryEntity> findAllByCategoryGroup(Integer id,Integer idCr);
}

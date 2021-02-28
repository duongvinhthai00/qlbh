package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.CategoryGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryGroupDao extends JpaRepository<CategoryGroupEntity,Integer> {
}

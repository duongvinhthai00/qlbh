package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Integer> {
    @Query("select p from ProductEntity p where p.pro_category_id.id = ?1")
    List<ProductEntity> GetProductByCategoryId(Integer CategoryId);
}

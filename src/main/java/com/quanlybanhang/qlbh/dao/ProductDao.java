package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Integer> {
    @Query("select p from ProductEntity p where p.pro_category_id.id = ?1")
    List<ProductEntity> GetProductByCategoryId(Integer CategoryId);

    @Query("select p from ProductEntity p where p.pr_name LIKE lower(concat('%', concat(:place, '%'))) or p.pro_category_id.c_name LIKE lower(concat('%', concat(:place, '%'))) or p.pro_place_sale LIKE lower(concat('%', concat(:place, '%')))")
    List<ProductEntity> SearchProducts(@Param("place") String searchInput);

}

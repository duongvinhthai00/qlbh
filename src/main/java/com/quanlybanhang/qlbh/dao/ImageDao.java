package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<ImageEntity,Integer> {
    @Query("SELECT i from ImageEntity i where i.im_product_id .id= ?1")
    List<ImageEntity> findImagesByProductId(Integer id);

    @Transactional
    @Modifying
    @Query("delete from ImageEntity i where i.im_product_id.id = ?1 ")
    void DeleteImageProduct(Integer pro_id);
}

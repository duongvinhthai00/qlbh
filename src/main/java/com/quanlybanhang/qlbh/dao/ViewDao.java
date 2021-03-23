package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewDao extends JpaRepository<ViewEntity,Integer> {

    @Query("select v from ViewEntity v where v.pro_id.id = ?1 and v.user_id.id = ?2")
    ViewEntity GetView(Integer pro_id,Integer user_id);
}

package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDao extends JpaRepository<CardEntity,Integer> {
    @Query("select k from CardEntity k where k.c_user_id.id = ?1")
    List<CardEntity> findCardAllByUser(Integer userId);
}

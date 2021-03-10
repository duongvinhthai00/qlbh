package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity,Integer> {

    @Query("select k from TransactionEntity k where k.tr_user_id.id = ?1")
    List<TransactionEntity> GetTransactionByUser(Integer userId);
}

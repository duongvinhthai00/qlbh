package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity,Integer> {
}

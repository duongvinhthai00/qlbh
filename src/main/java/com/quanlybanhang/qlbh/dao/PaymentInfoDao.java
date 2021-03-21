package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.PaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoDao extends JpaRepository<PaymentInfoEntity,Integer> {
}

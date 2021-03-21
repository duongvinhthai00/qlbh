package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportDao extends JpaRepository<TransportEntity, Integer> {
}

package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,Integer> {
}

package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewDao extends JpaRepository<ViewEntity,Integer> {
}

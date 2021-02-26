package com.quanlybanhang.qlbh.dao;


import com.quanlybanhang.qlbh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	
}

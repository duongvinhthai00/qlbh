package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity,Integer>{
    @Query("SELECT a from AdminEntity a where a.user_name = ?1 and a.password = ?2")
    AdminEntity CheckAdminLogin(String userName, String password);
}

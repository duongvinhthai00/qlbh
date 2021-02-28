package com.quanlybanhang.qlbh.dao;


import com.quanlybanhang.qlbh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT u from UserEntity u where u.user_name = ?1 and u.password = ?2")
    UserEntity CheckUserLogin(String userName,String password);
}

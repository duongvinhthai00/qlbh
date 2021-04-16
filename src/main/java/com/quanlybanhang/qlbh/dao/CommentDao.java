package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<CommentEntity,Integer> {
    @Query("select c from CommentEntity c where c.pro_id.id=?1")
    List<CommentEntity> getAllCommentByPro(Integer pro_id);
}

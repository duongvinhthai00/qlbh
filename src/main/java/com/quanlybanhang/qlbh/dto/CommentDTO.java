package com.quanlybanhang.qlbh.dto;


import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private String content;
    private Timestamp created_at;
    private UserEntity user_id;
    private ProductEntity pro_id;
}

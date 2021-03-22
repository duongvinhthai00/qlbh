package com.quanlybanhang.qlbh.dto;


import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewDTO {
    private Integer id;
    private Integer view_number;
    private Integer rating_number;
    private UserEntity user_id;
    private ProductEntity pro_id;
}

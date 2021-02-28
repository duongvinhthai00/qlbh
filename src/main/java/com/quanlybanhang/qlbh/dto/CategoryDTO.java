package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Integer id ;
    private String c_name ;
    private String c_slug ;
    private String c_icon ;
    private String c_avatar ;
    private Integer c_active ;
    private Integer c_total_product ;
    private Integer c_home ;
    private Timestamp created_at ;
    private Timestamp updated_at ;
    private AdminDTO c_author_id ;
    private CategoryGroupDTO c_group_id;
}

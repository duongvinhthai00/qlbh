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
public class ArticleDTO {
    private Integer id;
    private String a_name ;
    private String a_slug ;
    private String a_description ;
    private String a_content ;
    private Integer a_active;
    private String a_avatar ;
    private Integer a_view ;
    private Integer a_hot ;
    private Timestamp created_at;
    private Timestamp updated_at;
    private CategoryDTO a_category_id;
    private AdminDTO a_author_id;
}

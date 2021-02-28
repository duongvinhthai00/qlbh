package com.quanlybanhang.qlbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "a_category_id")
    private CategoryEntity a_category_id;

    @ManyToOne
    @JoinColumn(name = "a_author_id")
    private AdminEntity a_author_id;
}

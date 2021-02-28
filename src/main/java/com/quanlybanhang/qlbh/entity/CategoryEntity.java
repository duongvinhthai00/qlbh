package com.quanlybanhang.qlbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "c_author_id")
    private AdminEntity c_author_id ;

    @ManyToOne
    @JoinColumn(name = "c_group_id")
    private CategoryGroupEntity c_group_id;

    @OneToMany(mappedBy = "pro_category_id",fetch = FetchType.LAZY)
    private List<ProductEntity> listProducts;

    @OneToMany(mappedBy = "a_category_id",fetch = FetchType.LAZY)
    private List<ArticleEntity> listArticles;
}

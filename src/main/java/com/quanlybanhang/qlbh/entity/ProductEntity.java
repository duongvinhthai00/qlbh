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
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pr_name ;
    private String pro_slug;
    private Integer pro_price;
    private Integer pro_sale ;
    private Integer pro_active ;
    private Integer pro_hot ;
    private Integer pro_pay ;
    private Integer pro_number ;
    private String pro_description ;
    private String pro_avatar ;
    private String pro_content ;
    private Timestamp created_at ;
    private Timestamp updated_at ;
    private Integer pro_view;
    private String pro_place_sale;

    @ManyToOne
    @JoinColumn(name = "pro_category_id")
    private CategoryEntity pro_category_id;

    @ManyToOne
    @JoinColumn(name = "pro_author_id")
    private AdminEntity pro_author_id;

    @ManyToOne
    @JoinColumn(name = "s_suppliers_id")
    private SupplierEntity s_suppliers_id;

    @OneToMany(mappedBy = "or_product_id",fetch = FetchType.LAZY)
    private List<OrderEntity> listOrders;

    @OneToMany(mappedBy = "im_product_id",fetch = FetchType.LAZY)
    private List<ImageEntity> listImages;

    @OneToMany(mappedBy = "c_product_id",fetch = FetchType.LAZY)
    private List<CardEntity> listCards;

    @OneToMany(mappedBy = "pro_id",fetch = FetchType.LAZY)
    private List<ViewEntity> viewEntityList;
}

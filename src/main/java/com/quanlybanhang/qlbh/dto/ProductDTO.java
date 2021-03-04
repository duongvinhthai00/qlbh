package com.quanlybanhang.qlbh.dto;

import com.quanlybanhang.qlbh.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
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

    private CategoryDTO pro_category_id;
    private AdminDTO pro_author_id;
    private SupplierDTO s_suppliers_id;

}

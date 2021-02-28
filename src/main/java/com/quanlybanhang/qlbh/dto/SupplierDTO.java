package com.quanlybanhang.qlbh.dto;

import com.quanlybanhang.qlbh.entity.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private Integer id ;
    private String s_name;
    private String s_email ;
    private String s_phone ;
    private String s_fax ;
    private String s_website ;
    private String s_logo ;
    private Integer s_status ;
    private Timestamp created_at ;
    private Timestamp updated_at ;

    private AdminDTO s_author_id;
}

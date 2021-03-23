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
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "s_author_id")
    private AdminEntity s_author_id;

}

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
@Table(name = "admins")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    private String email ;
    private String phone ;
    private String avatar ;
    private Integer active;
    private String password ;
    private Timestamp created_at ;
    private Timestamp update_at ;
    private String user_name ;

}

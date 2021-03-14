package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
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

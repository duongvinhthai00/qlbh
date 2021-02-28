package com.quanlybanhang.qlbh.dto;

import com.quanlybanhang.qlbh.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Integer id;
    private Integer tr_total;
    private String tr_note;
    private String tr_address ;
    private String tr_phone ;
    private Integer tr_status;
    private Timestamp created_at;
    private Timestamp updated_at;

    private UserDTO tr_user_id;
}

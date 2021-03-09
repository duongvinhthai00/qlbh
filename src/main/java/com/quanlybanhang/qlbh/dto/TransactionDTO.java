package com.quanlybanhang.qlbh.dto;

import com.quanlybanhang.qlbh.entity.UserEntity;
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
public class TransactionDTO {
    private Integer id;
    private Integer tr_total;
    private String tr_note;
    @NotBlank(message = "Địa Chỉ Không Được Bỏ Trống")
    private String tr_address;
    @NotBlank(message = "Số Điện Thoại Không Được Bỏ Trống")
    private String tr_phone ;
    private Integer tr_status;
    private Timestamp created_at;
    private Timestamp updated_at;
    @NotBlank(message = "Tên Người Đặt Hàng Không Được Để Trống")
    private String name;

    private UserDTO tr_user_id;
}

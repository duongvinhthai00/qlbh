package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Phương Thức Thanh Toán Không Được Để Trống")
    private Integer payment;
    private Integer payment_status;

    private UserDTO tr_user_id;
    @NotNull(message = "Phương Thức Vận Chuyển Không Được Để Trống")
    private TransportDTO tr_transport_id;
}

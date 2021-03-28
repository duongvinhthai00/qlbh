package com.quanlybanhang.qlbh.dto;

import com.quanlybanhang.qlbh.entity.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoDTO {
    private Integer id;
    private String image;
    @NotBlank(message = "Tên Chủ Thẻ Không Được Bỏ Trống")
    private String account_name;
    @NotBlank(message = "Số Tài Khoảng Không Được Bỏ Trống")
    private String account_number;
    @NotBlank(message = "Số Thẻ Không Được Bỏ Trống")
    private String account_seri;
    @NotBlank(message = "Tên Ngân Hàng Không Được Bỏ Trống")
    private String bank_name;
    private AdminEntity pay_author_id;
}

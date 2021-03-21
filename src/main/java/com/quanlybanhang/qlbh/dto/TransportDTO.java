package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportDTO {
    private Integer id;
    @NotBlank(message = "Tên Phương Thức Giao Hàng Không Được Bỏ Trống")
    private String name;
    @NotBlank(message = "Thơi Gian Giao Hàng Không Được Bỏ Trống")
    private String time;
    @NotNull(message = "Phí Giao Hàng Không Được Bỏ Trống")
    private Integer fee;
}

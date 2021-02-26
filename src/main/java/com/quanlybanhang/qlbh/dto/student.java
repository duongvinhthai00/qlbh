package com.quanlybanhang.qlbh.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class student {
    @Min(value = 1,message = "khong duoc be hon 1")
    private int rollName;
}

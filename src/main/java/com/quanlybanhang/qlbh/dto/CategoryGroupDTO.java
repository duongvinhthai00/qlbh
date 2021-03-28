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
public class CategoryGroupDTO {
    private Integer id;
    @NotBlank(message = "Tên Danh Mục Cha Không Được Bỏ Trống")
    private String name;
    private AdminEntity group_author_id;
}

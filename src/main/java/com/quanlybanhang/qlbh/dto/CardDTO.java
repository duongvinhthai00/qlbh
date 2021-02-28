package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    private Integer id;
    private Integer c_qty;
    private ProductDTO c_product_id;
    private UserDTO c_user_id;
}

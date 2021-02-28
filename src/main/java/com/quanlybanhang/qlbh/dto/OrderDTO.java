package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id ;
    private Integer or_qty;
    private Integer or_price;
    private Integer or_price_old ;
    private Integer or_sale;
    private Timestamp created_at ;
    private Timestamp update_at;

    private TransactionDTO or_transaction_id;
    private ProductDTO or_product_id;
    private UserDTO or_user_id;
}

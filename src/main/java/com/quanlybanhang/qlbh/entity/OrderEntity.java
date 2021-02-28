package com.quanlybanhang.qlbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer or_qty;
    private Integer or_price;
    private Integer or_price_old ;
    private Integer or_sale;
    private Timestamp created_at ;
    private Timestamp update_at;

    @ManyToOne
    @JoinColumn(name = "or_transaction_id")
    private TransactionEntity or_transaction_id;

    @ManyToOne
    @JoinColumn(name = "or_product_id")
    private ProductEntity  or_product_id;

    @ManyToOne
    @JoinColumn(name = "or_user_id")
    private UserEntity  or_user_id;
}

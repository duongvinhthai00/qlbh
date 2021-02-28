package com.quanlybanhang.qlbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer c_qty;

    @ManyToOne
    @JoinColumn(name = "c_product_id")
    private ProductEntity c_product_id;

    @ManyToOne
    @JoinColumn(name = "c_user_id")
    private UserEntity c_user_id;
}

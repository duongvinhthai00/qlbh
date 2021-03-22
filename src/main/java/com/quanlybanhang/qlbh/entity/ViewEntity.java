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
@Table(name = "view")
public class ViewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer view_number;
    private Integer rating_number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProductEntity pro_id;
}

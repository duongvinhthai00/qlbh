package com.quanlybanhang.qlbh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tr_total;
    private String tr_note;
    private String tr_address ;
    private String tr_phone ;
    private Integer tr_status;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private Integer payment;
    private Integer payment_status;
    @ManyToOne
    @JoinColumn(name = "tr_user_id")
    private UserEntity tr_user_id;

    @ManyToOne
    @JoinColumn(name = "tr_transport_id")
    private TransportEntity tr_transport_id;

}

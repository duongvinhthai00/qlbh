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
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Timestamp created_at;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProductEntity pro_id;
}

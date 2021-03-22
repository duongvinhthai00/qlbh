package com.quanlybanhang.qlbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String phone;
	private String avatar;
	private String active;
	private String password;
	private String name;
	private String email;
	private Integer total_pay;
	private String address;
	private String about;
	private Timestamp created_at;
	private Timestamp update_at;
	private String user_name;

	@OneToMany(mappedBy = "tr_user_id",fetch = FetchType.LAZY)
	private List<TransactionEntity> listTransactions;

	@OneToMany(mappedBy = "or_user_id",fetch = FetchType.LAZY)
	private List<OrderEntity> listOrders;

	@OneToMany(mappedBy = "c_user_id",fetch = FetchType.LAZY)
	private List<CardEntity> listCards;

	@OneToMany(mappedBy = "user_id",fetch = FetchType.LAZY)
	private List<ViewEntity> viewEntityList;
}

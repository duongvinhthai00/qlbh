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
public class UserDTO {
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



	
}

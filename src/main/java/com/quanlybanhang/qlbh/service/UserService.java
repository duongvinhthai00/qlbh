package com.quanlybanhang.qlbh.service;


import com.quanlybanhang.qlbh.dto.UserDTO;

import java.util.List;

public interface UserService {
	List<UserDTO> findUserAll();
	UserDTO findUserById(Integer id);
	UserDTO addUser(UserDTO userDTO);
	void deleteUser(Integer id);
	void updateUser(UserDTO userDTO);
}

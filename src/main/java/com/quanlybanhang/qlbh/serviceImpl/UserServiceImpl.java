package com.quanlybanhang.qlbh.serviceImpl;


import com.quanlybanhang.qlbh.dao.UserDao;
import com.quanlybanhang.qlbh.dto.UserDTO;
import com.quanlybanhang.qlbh.entity.UserEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.exception.NotFoundException;
import com.quanlybanhang.qlbh.modalmapping.UserMapper;
import com.quanlybanhang.qlbh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserDTO> findUserAll() {
		List<UserEntity> listUserEntity = userDao.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		for(UserEntity user : listUserEntity) {
			UserDTO userDTO = UserMapper.entity2DTO(user);
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	@Override
	public UserDTO findUserById(Integer id) {
		try {
			UserEntity userEntity = userDao.findById(id).get();
			UserDTO userDTO = UserMapper.entity2DTO(userEntity);
			return userDTO;
		}catch (Exception e){
			throw new NotFoundException("Khong Tim Thay User");
		}

	}

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		try {
			UserEntity userEntity = UserMapper.dto2Entity(userDTO);
			userDao.save(userEntity);
			return userDTO;
		}catch (Exception e){
			throw new ExceptionGobal("User Name Da ton Tai");
		}

	}

	@Override
	public void deleteUser(Integer id) {
		UserEntity userEntity =null;
		try {
			 userEntity = userDao.findById(id).get();
		}catch (Exception e){
			throw new ExceptionGobal("User Khong Ton Tai");
		}
		try {
			userDao.delete(userEntity);
		}catch (Exception e){
			throw new ExceptionGobal("Xoa Khong thanh cong");
		}

	}

	@Override
	public void updateUser(UserDTO userDTO) {
		UserEntity userEntity = null;
		try {
			 userEntity = userDao.findById(userDTO.getId()).get();
		}catch (Exception e){
			throw  new ExceptionGobal("Khong Tim Thay User De Chinh Sua");
		}

		try {
			if(userEntity != null) {
				userEntity = UserMapper.dto2Entity(userDTO);
				userDao.save(userEntity);
			}
		}catch (Exception e){
			throw new ExceptionGobal("UserName Khong Duoc Trung");
		}

	}

	@Override
	public Boolean Login(String userName, String passWord) {
		return true;
	}


}

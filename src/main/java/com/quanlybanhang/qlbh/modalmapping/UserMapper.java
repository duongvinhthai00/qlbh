package com.quanlybanhang.qlbh.modalmapping;


import com.quanlybanhang.qlbh.dto.UserDTO;
import com.quanlybanhang.qlbh.entity.UserEntity;
import org.modelmapper.ModelMapper;

public class UserMapper {
	private static ModelMapper modelMapper = new ModelMapper();
	public static UserDTO entity2DTO(UserEntity userEntitiy) {
		UserDTO userDTO = modelMapper.map(userEntitiy,UserDTO.class);
		return userDTO;
	}
	
	public static UserEntity dto2Entity(UserDTO userDTO) {
		UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
		return userEntity;
	}

}

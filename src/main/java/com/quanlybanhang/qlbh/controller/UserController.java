package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.UserDTO;
import com.quanlybanhang.qlbh.dto.student;
import com.quanlybanhang.qlbh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public ResponseEntity<?> getAllUsers() {
		List<UserDTO> listUser = userService.findUserAll();
		return new ResponseEntity<List<UserDTO>>(listUser, HttpStatus.OK);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
		
		UserDTO userDTO = userService.findUserById(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping("sv")
	public student kq(@Valid @RequestBody student s){
		return s;
	}
	
}

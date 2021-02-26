package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.UserDTO;
import com.quanlybanhang.qlbh.service.UserService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private MapValidationService mapValidationService;
	
	@GetMapping("users")
	public ResponseEntity<?> getAllUsers() {
		List<UserDTO> listUser = userService.findUserAll();
		return new ResponseEntity<List<UserDTO>>(listUser, HttpStatus.OK);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		UserDTO userDTO = userService.findUserById(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping("users")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO, BindingResult result){
		if(result.hasErrors()){
			return mapValidationService.getMapValidationError(result);
		}
		UserDTO dto = userService.addUser(userDTO);
		return new ResponseEntity<UserDTO>(dto,HttpStatus.CREATED);
	}

	@PutMapping("users")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO userDTO,BindingResult result){
		if(result.hasErrors()){
			return mapValidationService.getMapValidationError(result);
		}
		userService.updateUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
	}
	
}

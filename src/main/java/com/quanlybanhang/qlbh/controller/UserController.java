package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.LoginDTO;
import com.quanlybanhang.qlbh.dto.UserDTO;
import com.quanlybanhang.qlbh.service.UserService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import com.quanlybanhang.qlbh.serviceImpl.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	@Value("${upload.path}")
	private String fileUpload;


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
		System.out.println("Vo");
		if(result.hasErrors()){
			return mapValidationService.getMapValidationError(result);
		}
		userDTO = userService.addUser(userDTO);
		return new ResponseEntity<Integer>(userDTO.getId(),HttpStatus.CREATED);
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

	@PostMapping("users/login")
	public ResponseEntity<?> UserCheckLogin(@Valid @RequestBody LoginDTO loginDTO, BindingResult result){
		if(result.hasErrors()){
			return mapValidationService.getMapValidationError(result);
		}
		return new ResponseEntity<UserDTO>(userService.CheckUserLogin(loginDTO),HttpStatus.OK);
	}

	@PostMapping("users/upload/{id}")
	public Boolean userUploadFile(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
		System.out.println(id);
		UserDTO userDTO = userService.findUserById(id);
		String fileName = UploadFileService.UploadOneFile(file,fileUpload);
		userDTO.setAvatar(fileName);
		userService.updateUser(userDTO);
		return true;
	}

}

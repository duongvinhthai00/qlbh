package com.quanlybanhang.qlbh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Integer id;
	@NotBlank(message = "phone Không Được Để Trống")
	private String phone;
	private String avatar;
	private String active;
	@NotBlank(message = "password Không Được Để Trống")
	private String password;
	@NotBlank(message = "name Không Được Để Trống")
	private String name;
	@NotBlank(message = "email Không Được Để Trống")
	private String email;
	private Integer total_pay;
	@NotBlank(message = "address Không Được Để Trống")
	private String address;
	private String about;
	private Timestamp created_at;
	private Timestamp update_at;
	@NotBlank(message = "user_name Không Được Để Trống")
	private String user_name;
	private MultipartFile fileupload;


	
}

package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.AdminDTO;
import com.quanlybanhang.qlbh.dto.LoginDTO;
import com.quanlybanhang.qlbh.service.AdminService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MapValidationService mapValidationService;

    @GetMapping("admins")
    public ResponseEntity<?> getAllAdmins() {
        List<AdminDTO> listAdmin = adminService.findAdminAll();
        return new ResponseEntity<List<AdminDTO>>(listAdmin, HttpStatus.OK);
    }

    @GetMapping("admins/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable int id){
        AdminDTO adminDTO = adminService.findAdminById(id);
        return ResponseEntity.ok().body(adminDTO);
    }

    @PostMapping("admins")
    public ResponseEntity<?> addAdmin(@Valid @RequestBody AdminDTO adminDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        AdminDTO dto = adminService.addAdmin(adminDTO);
        return new ResponseEntity<AdminDTO>(dto,HttpStatus.CREATED);
    }

    @PutMapping("admins")
    public ResponseEntity<?> updateAdmin(@Valid @RequestBody AdminDTO adminDTO,BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        adminService.updateAdmin(adminDTO);
        return new ResponseEntity<AdminDTO>(adminDTO,HttpStatus.OK);
    }

    @DeleteMapping("admins/{id}")
    public Boolean deleteAdmin(@PathVariable int id){
        adminService.deleteAdmin(id);
        return true;
    }

    @PostMapping("admins/login")
    public ResponseEntity<?> AdminCheckLogin(@Valid @RequestBody LoginDTO loginDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        return new ResponseEntity<AdminDTO>(adminService.CheckAdminLogin(loginDTO),HttpStatus.OK);
    }
}

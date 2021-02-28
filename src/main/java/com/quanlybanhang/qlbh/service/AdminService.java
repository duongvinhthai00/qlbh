package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    List<AdminDTO> findAdminAll();
    AdminDTO findAdminById(Integer id);
    AdminDTO addAdmin(AdminDTO adminDTO);
    void deleteAdmin(Integer id);
    void updateAdmin(AdminDTO adminDTO);
    Boolean CheckAdminLogin(AdminDTO adminDTO);
}

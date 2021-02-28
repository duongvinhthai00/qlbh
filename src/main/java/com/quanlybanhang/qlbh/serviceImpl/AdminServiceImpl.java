package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.AdminDao;
import com.quanlybanhang.qlbh.dto.AdminDTO;
import com.quanlybanhang.qlbh.entity.AdminEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.exception.NotFoundException;
import com.quanlybanhang.qlbh.modalmapping.AdminMapper;
import com.quanlybanhang.qlbh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<AdminDTO> findAdminAll() {
        List<AdminEntity> listAdminEntity = adminDao.findAll();
        List<AdminDTO> listAdminDTO = new ArrayList<>();
        for(AdminEntity admin : listAdminEntity) {
            AdminDTO adminDTO = AdminMapper.entity2DTO(admin);
            listAdminDTO.add(adminDTO);
        }
        return listAdminDTO;
    }

    @Override
    public AdminDTO findAdminById(Integer id) {
        try {
            AdminEntity adminEntity = adminDao.findById(id).get();
            AdminDTO adminDTO = AdminMapper.entity2DTO(adminEntity);
            return adminDTO;
        }catch (Exception e){
            throw new NotFoundException("Không Tìm Thấy Admin");
        }

    }


    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        try {
            AdminEntity adminEntity = AdminMapper.dto2Entity(adminDTO);
            adminDao.save(adminEntity);
            return adminDTO;
        }catch (Exception e){
            throw new ExceptionGobal("Tên Người Dùng Đã Tồn Tại");
        }
    }

    @Override
    public void deleteAdmin(Integer id) {
        AdminEntity adminEntity =null;
        try {
            adminEntity = adminDao.findById(id).get();
        }catch (Exception e){
            throw new ExceptionGobal("Admin Không Tồn Tại");
        }
        try {
            adminDao.delete(adminEntity);
        }catch (Exception e){
            throw new ExceptionGobal("Xóa Không Thành Công");
        }
    }


    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        AdminEntity adminEntity = null;
        try {
            adminEntity = adminDao.findById(adminDTO.getId()).get();
        }catch (Exception e){
            throw  new ExceptionGobal("Không Tìm Thấy UserAdmin Để Chỉnh Sửa");
        }

        try {
            if(adminEntity != null) {
                adminEntity = AdminMapper.dto2Entity(adminDTO);
                adminDao.save(adminEntity);
            }
        }catch (Exception e){
            throw new ExceptionGobal("UserName Không Được Trùng");
        }

    }

    @Override
    public Boolean CheckAdminLogin(AdminDTO adminDTO) {
        AdminEntity adminEntity = adminDao.CheckAdminLogin(adminDTO.getUser_name(),adminDTO.getPassword());
        if(adminEntity == null){
            throw new ExceptionGobal("Tài Khoảng Hoặc Mật Khẩu Không Chính Xác");
        }
        return true;
    }
}

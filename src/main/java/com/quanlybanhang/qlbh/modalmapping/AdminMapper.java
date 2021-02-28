package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.AdminDTO;
import com.quanlybanhang.qlbh.entity.AdminEntity;
import org.modelmapper.ModelMapper;

public class AdminMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static AdminDTO entity2DTO(AdminEntity adminEntity) {
        AdminDTO adminDTO = modelMapper.map(adminEntity, AdminDTO.class);
        return adminDTO;
    }

    public static AdminEntity dto2Entity(AdminDTO adminDTO) {
        AdminEntity adminEntity = modelMapper.map(adminDTO,AdminEntity.class);
        return adminEntity;
    }
}

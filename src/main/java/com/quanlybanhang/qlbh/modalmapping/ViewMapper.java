package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.ViewDTO;
import com.quanlybanhang.qlbh.entity.ViewEntity;
import org.modelmapper.ModelMapper;

public class ViewMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static ViewDTO entity2DTO(ViewEntity viewEntity) {
        ViewDTO viewDTO = modelMapper.map(viewEntity,ViewDTO.class);
        return viewDTO;
    }

    public static ViewEntity dto2Entity(ViewDTO viewDTO) {
        ViewEntity viewEntity = modelMapper.map(viewDTO,ViewEntity.class);
        return viewEntity;
    }
}

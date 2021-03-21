package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.TransportDTO;
import com.quanlybanhang.qlbh.entity.TransportEntity;
import org.modelmapper.ModelMapper;

public class TransportMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static TransportDTO entity2DTO(TransportEntity transportEntity) {
        TransportDTO transportDTO = modelMapper.map(transportEntity,TransportDTO.class);
        return transportDTO;
    }

    public static TransportEntity dto2Entity(TransportDTO transportDTO) {
        TransportEntity transportEntity = modelMapper.map(transportDTO,TransportEntity.class);
        return transportEntity;
    }
}
